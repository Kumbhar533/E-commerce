package com.ms.ecommerce.payment.request.response;

import java.math.BigDecimal;

import com.ms.ecommerce.payment.entities.Customer;
import com.ms.ecommerce.payment.entities.PaymentMethod;

public record PaymentRequest(

		Integer id,

		BigDecimal amount,

		PaymentMethod paymentMethod,

		Integer orderId,

		String orderReference,

		Customer customer) {

}
