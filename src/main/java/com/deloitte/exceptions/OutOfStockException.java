package com.deloitte.exceptions;

//Ice cream Machine will throw this exception, 
//if the product selected by user is out of stock
public class OutOfStockException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5687294428173074777L;
	
	private String msg;

	public String getMsg() {
		return msg;
	}

	public OutOfStockException(String msg) {
		this.msg = msg;
	}
	
	
}
