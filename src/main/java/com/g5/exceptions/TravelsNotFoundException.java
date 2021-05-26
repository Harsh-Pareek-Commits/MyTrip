package com.g5.exceptions;

public class TravelsNotFoundException extends Exception {

	public TravelsNotFoundException() {
		super();
		
	}

	public TravelsNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public TravelsNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public TravelsNotFoundException(String message) {
		super(message);
		
	}

	public TravelsNotFoundException(Throwable cause) {
		super(cause);
		
	}

}
