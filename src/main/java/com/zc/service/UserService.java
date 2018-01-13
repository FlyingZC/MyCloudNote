package com.zc.service;


import java.util.List;
import java.util.Map;

import com.zc.entity.User;
import com.zc.exception.PasswordException;
import com.zc.exception.UserNameException;
import com.zc.exception.UserNotFoundException;

public interface UserService {
	User login(String name,String password) throws UserNameException,PasswordException;
	/**
	 * @param name
	 * @param nick
	 * @param password
	 * @param confirm 确认密码
	 * @return
	 * @throws UserNameException
	 * @throws PasswordException
	 */
	User regist(String name,String nick,String password,String confirm) throws UserNameException,PasswordException;
}
