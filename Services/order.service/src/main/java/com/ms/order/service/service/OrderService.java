package com.ms.order.service.service;

import org.springframework.stereotype.Service;

import com.ms.order.service.customer.CustomerClient;
import com.ms.order.service.exception.BussinessException;
import com.ms.order.service.kafka.OrderConfirmation;
import com.ms.order.service.kafka.OrderProducer;
import com.ms.order.service.product.ProductClient;
import com.ms.order.service.reposistory.OrderReposistory;
import com.ms.order.service.request.response.OrderLineRequest;
import com.ms.order.service.request.response.OrderMapper;
import com.ms.order.service.request.response.OrderRequest;
import com.ms.order.service.request.response.PurchaseRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final CustomerClient customerClient;

	private final ProductClient productClient;

	private final OrderReposistory repository;

	private final OrderMapper mapper;

	private final OrderLineService orderLineService;

	private final OrderProducer orderProducer;

	public Integer createOrder(@Valid OrderRequest request) {
//1
		var customer = this.customerClient.findCustomerById(request.customerId()).orElseThrow(
				() -> new BussinessException("Order not created::Customer not exists with the provided id"));

		// 2
		var purchaseProducts = this.productClient.purchaseProducts(request.purchase());

		// 3
		var order = this.repository.save(mapper.toOrder(request));

		// 4
		for (PurchaseRequest purchaseRequest : request.purchase()) {

			this.orderLineService.saveOrderLine(
					new OrderLineRequest(null, order.getId(), purchaseRequest.productId(), purchaseRequest.quantity()));

		}
		// 5
		orderProducer.sendOrderConfirmation(new OrderConfirmation(request.reference(), request.amount(),
				purchaseProducts, customer, request.paymentMethod()));

		return null;
	}

}
