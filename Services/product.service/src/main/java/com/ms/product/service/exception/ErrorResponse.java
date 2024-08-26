package com.ms.product.service.exception;

import java.util.Map;

public class ErrorResponse {

	private Map<String, String> error;

	public ErrorResponse(Map<String, String> error) {
		super();
		this.error = error;
	}

}
