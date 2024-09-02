package com.ms.ecommerce.notification.email;

import lombok.Getter;

public enum EmailTemplate {

	PAYMENT_CONFIRMATION("payment-confirmation.html", "Payment Sucessfully Confirmed"),

	ORDER_CONFIRMATION("order-confirmation.html", "Order confirmation");

	@Getter
	private String template;

	@Getter
	private String subject;

	EmailTemplate(String template, String subject) {
		this.subject = subject;
		this.template = template;
	}

}
