package com.zc.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zc.exception.UserNotFoundException;
import com.zc.service.NoteBookService;
import com.zc.util.JsonResult;

@Controller
@RequestMapping("/notebook")
public class NoteBookController extends BaseController{
	@Resource
	private NoteBookService noteBookService;
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonResult<List<Map<String,Object>>> list(String userId) throws UserNotFoundException{
		return new JsonResult<List<Map<String,Object>>>(noteBookService.listNoteBooks(userId));
	}
	
	
}
