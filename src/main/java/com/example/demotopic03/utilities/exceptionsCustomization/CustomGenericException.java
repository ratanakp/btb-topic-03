package com.example.demotopic03.utilities.exceptionsCustomization;

public class CustomGenericException extends RuntimeException {

	private static final long serialVersionUID = 2223401815627927627L;

	private String code;
	private String message;
	
	public CustomGenericException(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public CustomGenericException() {
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CustomGenericException{" +
				"code='" + code + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
