package com.g5.tms.exceptions;

public class ReportNotFoundException extends Exception {

	public ReportNotFoundException() {
		super();
		
	}

	public ReportNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	
	}

	public ReportNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ReportNotFoundException(String message) {
		super(message);
	
	}

	public ReportNotFoundException(Throwable cause) {
		super(cause);
		
	}

}
