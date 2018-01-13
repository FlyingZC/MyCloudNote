package com.zc.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zc.util.JsonResult;

public abstract class BaseController {
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonResult expHandle(Exception e){
		e.printStackTrace();
		return new JsonResult(e);
	}
}
