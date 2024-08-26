package com.ms.product.service.exception;

public class ProductPurchaseException extends RuntimeException {

	private String msg;

	public ProductPurchaseException(String msg) {
		super();
		this.msg = msg;
	}

}
