package com.ms.order.service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.order.service.request.response.OrderLineResponse;
import com.ms.order.service.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order-lines")
public class OrderLineController {

	private final OrderService orderService;

	@GetMapping("/{order-id}")
	public ResponseEntity<List<OrderLineResponse>> findOrderLinesByOrderId(@PathVariable("order-id") Integer orderId) {

		return ResponseEntity.ok(orderService.findAllOrderLines(orderId));

	}

}
