package com.ms.order.service.service;

import org.springframework.stereotype.Service;

import com.ms.order.service.reposistory.OrderLineReposistory;
import com.ms.order.service.request.response.OrderLineMapper;
import com.ms.order.service.request.response.OrderLineRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderLineService {

	private final OrderLineReposistory reposistory;
	private final OrderLineMapper orderMapper;

	public void saveOrderLine(OrderLineRequest orderLineRequest) {

		var orderLine = orderMapper.toOrderLine(orderLineRequest);

		reposistory.save(orderLine);
	}

}
