package com.g5.tms.exceptions;
public class MyExceptionResponse {

	
	private int httpStatus;
	private String message;
	public int getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String exceptionMsg) {
		this.message = exceptionMsg;
	}
	public MyExceptionResponse(int httpStatus, String exceptionMsg) {
		super();
		this.httpStatus = httpStatus;
		this.message = exceptionMsg;
	}
	public MyExceptionResponse() {
		super();
	}

}
