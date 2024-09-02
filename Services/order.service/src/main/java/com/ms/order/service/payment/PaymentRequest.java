package com.ms.order.service.payment;

import java.math.BigDecimal;

import com.ms.order.service.order.PaymentMethod;
import com.ms.order.service.request.response.CustomerResponse;

public record PaymentRequest(

		BigDecimal amount,

		PaymentMethod paymentMethod,

		Integer orderId,

		String orderReference,

		CustomerResponse customer) {

}
