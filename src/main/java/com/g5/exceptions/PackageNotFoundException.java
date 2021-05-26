package com.g5.exceptions;

public class PackageNotFoundException extends Exception {

	public PackageNotFoundException() {
		super();
		
	}

	public PackageNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public PackageNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PackageNotFoundException(String message) {
		super(message);
		
	}

	public PackageNotFoundException(Throwable cause) {
		super(cause);
		
	}

}
