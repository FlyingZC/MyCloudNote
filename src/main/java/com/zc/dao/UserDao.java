package com.zc.dao;

import com.zc.entity.User;

public interface UserDao {
	void saveUser(User user);
	User findUserById(String id);
	User findUserByName(String name);
}




