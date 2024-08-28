package com.ms.order.service.kafka;

import java.math.BigDecimal;
import java.util.List;

import com.ms.order.service.order.PaymentMethod;
import com.ms.order.service.request.response.CustomerResponse;
import com.ms.order.service.request.response.PurchaseResponse;

public record OrderConfirmation(

		String orderReference, BigDecimal totalAmount, List<PurchaseResponse> products, CustomerResponse customer,
		PaymentMethod method

) {

}
