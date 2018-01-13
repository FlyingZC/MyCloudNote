package com.zc.util;

public class JsonResult<T> {
	public static final int SUCCESS=0;
	public static final int ERROR=1;
	private int state;
	private T data;
	private String message;
	public JsonResult(){
		
	}
	public JsonResult(T t){//返回正确json数据的构造方法
		state=SUCCESS;
		data=t;
		message="";
	}
	public JsonResult(Throwable th){//返回错误json数据的构造方法
		state=ERROR;
		data=null;
		message=th.getMessage();
	}
	public JsonResult(int state, Throwable e) {
		this.state=state;
		this.message=e.getMessage();
		this.data=null;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static int getSuccess() {
		return SUCCESS;
	}
	public static int getError() {
		return ERROR;
	}
	
}
