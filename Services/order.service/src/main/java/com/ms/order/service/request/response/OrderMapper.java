package com.ms.order.service.request.response;

import com.ms.order.service.order.Order;

public class OrderMapper {

	public Order toOrder(OrderRequest request) {

		return Order.builder().id(request.id()).customerId(request.customerId()).totalAmonut(request.amount())
				.reference(request.reference()).paymentMethod(request.paymentMethod()).build();

	}

}
