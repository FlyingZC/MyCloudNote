package com.zc.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zc.entity.User;
import com.zc.exception.PasswordException;
import com.zc.exception.UserNameException;
import com.zc.service.UserService;
import com.zc.util.JsonResult;
//控制器必须进行异常处理
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource(name="userService")
	private UserService userService;
	@RequestMapping("/login")
	@ResponseBody
	public JsonResult<User> login(String name,String password){
		User user=userService.login(name, password);
		return new JsonResult<User>(user);
	}
	//若抛异常,在json中使用state标记是否成功
	//JSON:{state:0,data:{id:..}}
	//JSON:{state:1,data:null,message:名字空}
	//state为0正常,state为1为Exception,state为2为UserNameException,state为3为PasswordException
	//反复重用的数据使用对象,一次性的数据使用json
	@RequestMapping("/regist")
	@ResponseBody
	public JsonResult<User> regist(String name,String nick,String password,String confirm){
		User user=userService.regist(name, nick, password, confirm);
		return new JsonResult<User>(user);
	}
	
	//添加异常处理方法,进行统一异常处理
	@ExceptionHandler(UserNameException.class)
	@ResponseBody
	public JsonResult<?> userName(UserNameException e){//当抛出UserNameExcepton异常时会调用该方法
		e.printStackTrace();
		return new JsonResult<User>(2,e);
	}
	@ExceptionHandler(PasswordException.class)
	@ResponseBody
	public JsonResult<?> password(PasswordException e){
	    e.printStackTrace();
	    return new JsonResult<User>(3, e);
	}
	
}
