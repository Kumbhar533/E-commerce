package com.ms.ecommerce.payment.entities;

import org.springframework.stereotype.Service;

import com.ms.ecommerce.payment.request.response.PaymentRequest;

@Service
public class PaymentMapper {

	public Payment toPayment(PaymentRequest paymentRequest) {

		return Payment.builder().id(paymentRequest.id()).amount(paymentRequest.amount())
				.orderId(paymentRequest.orderId()).paymentMethod(paymentRequest.paymentMethod()).build();
	}

}
