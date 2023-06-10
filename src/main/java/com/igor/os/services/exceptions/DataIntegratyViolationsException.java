package com.igor.os.services.exceptions;

public class DataIntegratyViolationsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegratyViolationsException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegratyViolationsException(String message) {
		super(message);
	}

}


