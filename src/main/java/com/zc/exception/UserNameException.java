package com.zc.exception;

public class UserNameException extends RuntimeException {
	//Generate Constructors from superclass
	private static final long serialVersionUID = 1L;

	public UserNameException() {
		super();
	}

	public UserNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserNameException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNameException(String message) {
		super(message);
	}

	public UserNameException(Throwable cause) {
		super(cause);
	}
	
}
