package com.zc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zc.dao.NoteBookDao;
import com.zc.dao.UserDao;
import com.zc.entity.User;
import com.zc.exception.UserNameException;
import com.zc.exception.UserNotFoundException;
import com.zc.service.NoteBookService;
@Service("noteBookService")
public class NoteBookServiceImpl implements NoteBookService{
	@Resource
	private NoteBookDao noteBookDao;
	@Resource
	private UserDao userDao;
	public List<Map<String, Object>> listNoteBooks(String userId) throws UserNotFoundException {
		if(userId==null||userId.trim().isEmpty()){
			throw new UserNameException("id为空");
		}
		User user=userDao.findUserById(userId);
		if(user==null){
			throw new UserNameException("查无此人");
		}
		return noteBookDao.findNoteBookByUserId(userId); 
	}
	
}
