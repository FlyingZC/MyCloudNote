package com.zc.dao;

import java.util.List;
import java.util.Map;

public interface NoteBookDao {
	List<Map<String,Object>> findNoteBookByUserId(String userId);
}
