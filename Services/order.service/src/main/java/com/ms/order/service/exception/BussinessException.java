package com.ms.order.service.exception;

public class BussinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String mes;

	public BussinessException(String mes) {
		super();
		this.mes = mes;
	}

}
