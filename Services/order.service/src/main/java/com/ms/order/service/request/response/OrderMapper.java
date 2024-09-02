package com.ms.order.service.request.response;

import org.springframework.stereotype.Service;

import com.ms.order.service.order.Order;
import com.ms.order.service.orderline.OrderLine;

@Service
public class OrderMapper {

	public Order toOrder(OrderRequest request) {

		return Order.builder().id(request.id()).customerId(request.customerId()).totalAmonut(request.amount())
				.reference(request.reference()).paymentMethod(request.paymentMethod()).build();

	}

	public OrderResponse fromOrder(Order order) {

		return new OrderResponse(order.getId(), order.getReference(), order.getTotalAmonut(), order.getPaymentMethod(),
				order.getCustomerId());

	}

	public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {

		return new OrderLineResponse(orderLine.getId(), orderLine.getQuantity());
	}

}
