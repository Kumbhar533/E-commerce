package com.ms.ecommerce.exception;

public class CustomerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String msg;

	public CustomerNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

}
