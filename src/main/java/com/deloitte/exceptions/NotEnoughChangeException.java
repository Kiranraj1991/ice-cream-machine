package com.deloitte.exceptions;

public class NotEnoughChangeException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5369310562608314313L;
	
	private String msg;

	public String getMsg() {
		return msg;
	}

	public NotEnoughChangeException(String msg) {
		this.msg = msg;
	}
	
	
}
