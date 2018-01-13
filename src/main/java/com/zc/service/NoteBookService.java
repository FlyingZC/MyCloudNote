package com.zc.service;

import java.util.List;
import java.util.Map;

import com.zc.exception.UserNotFoundException;

public interface NoteBookService {
	List<Map<String,Object>> listNoteBooks(String userId) throws UserNotFoundException;
}
