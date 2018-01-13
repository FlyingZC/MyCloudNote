package com.zc.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zc.dao.UserDao;
import com.zc.entity.User;
import com.zc.exception.PasswordException;
import com.zc.exception.UserNameException;
import com.zc.exception.UserNotFoundException;
import com.zc.service.UserService;
import com.zc.util.Md5Utils;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	public User login(String name, String password) throws UserNameException, PasswordException {
		//检测输入参数的合理性trim()去除前导后导空白
		if(name==null||name.trim().isEmpty()){
			//方法抛异常,方法结束,return为正常结束方法,throw异常结束方法
			throw new UserNameException("名不能空");
		}
		String reg="^\\w{3,10}$";
		if(!name.matches(reg)){
			throw new UserNameException("用户名不符合规则");
		}
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("密码不能为空");
		}
		String pswReg="^\\w{3,10}$";
		if(!password.matches(pswReg)){
			throw new PasswordException("密码不符合规则");
		}
		//查询用户数据
		User user=userDao.findUserByName(name);
		if(user==null){
			throw new UserNameException("用户名错误,数据库查无");
		}
		//少写else,多写if
		if(user.getPassword().equals(Md5Utils.crypt(password))){
			//业务处理
			//登录成功,返回用户信息
			return user;
		}
		//登录不成功,打日志,比如某个账号尝试登录次数过多,则冻结账号
		throw new PasswordException("密码错误");
	}
	public User regist(String name, String nick, String password, String confirm)
			throws UserNameException, PasswordException {
		name=name.trim();
		if(name==null||name.trim().isEmpty()){
			throw new UserNameException("用户名不能为空");
		}
		String reg="^\\w{3,10}$";
		if(!name.matches(reg)){
			throw new UserNameException("用户名格式不正确");
		}
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("密码不能为空");
		}
		password=password.trim();
		String pswReg="\\w{3,10}";
		if(!password.matches(pswReg)){
			throw new PasswordException("密码格式不正确");
		}
		if(!password.equals(confirm)){
			throw new PasswordException("密码不一致");
		}
		//验证用户名是否重复
		User one=userDao.findUserByName(name);
		if(one!=null){
			throw new UserNameException("用户名已存在");
		}
		//UUID用于产生永远不重复的ID,用于作为数据库中记录的主键
		String id=UUID.randomUUID().toString();
		String token="";
		//Md5加密密码
		String pwd=Md5Utils.crypt(password);
		User user=new User(id,name,pwd,token,nick);
		userDao.saveUser(user);
		return user;
	}
}
