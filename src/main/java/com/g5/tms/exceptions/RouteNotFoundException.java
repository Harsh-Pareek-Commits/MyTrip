package com.g5.tms.exceptions;

public class RouteNotFoundException extends Exception {

	public RouteNotFoundException() {
		super();
		
	}

	public RouteNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public RouteNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public RouteNotFoundException(String message) {
		super(message);
	
	}

	public RouteNotFoundException(Throwable cause) {
		super(cause);
		
	}

}
