package com.ms.order.service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.order.service.request.response.OrderRequest;
import com.ms.order.service.service.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping
@RestController
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	public ResponseEntity<Integer> createOrder(@RequestBody @Valid OrderRequest request) {
		return ResponseEntity.ok(orderService.createOrder(request));
	}
}
