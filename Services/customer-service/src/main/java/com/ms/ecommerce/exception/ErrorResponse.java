package com.ms.ecommerce.exception;

import java.util.Map;

public class ErrorResponse {

	private Map<String, String> error;

	public ErrorResponse(Map<String, String> error) {
		super();
		this.error = error;
	}

}
