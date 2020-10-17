package com.deloitte.exceptions;

public class NotPaidException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2801712165649592602L;
	
	private String msg;

	public String getMsg() {
		return msg;
	}

	public NotPaidException(String msg) {
		super();
		this.msg = msg;
	}
	

}
