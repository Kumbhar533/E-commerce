package com.ms.order.service.request.response;

import org.springframework.stereotype.Service;

import com.ms.order.service.order.Order;
import com.ms.order.service.orderline.OrderLine;

@Service
public class OrderLineMapper {

	public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {

		return OrderLine.builder().id(orderLineRequest.id()).productId(orderLineRequest.productId())
				.quantity(orderLineRequest.quantity()).order(Order.builder().id(orderLineRequest.id()).build()).build();
	}

}
