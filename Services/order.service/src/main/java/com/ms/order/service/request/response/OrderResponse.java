package com.ms.order.service.request.response;

import java.math.BigDecimal;

import com.ms.order.service.order.PaymentMethod;

public record OrderResponse(

		Integer id, String reference, BigDecimal amount, PaymentMethod paymentMethod, String customerId

) {

}
