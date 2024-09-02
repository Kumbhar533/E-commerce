package com.ms.order.service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ms.order.service.customer.CustomerClient;
import com.ms.order.service.exception.BussinessException;
import com.ms.order.service.kafka.OrderConfirmation;
import com.ms.order.service.kafka.OrderProducer;
import com.ms.order.service.payment.PaymentClient;
import com.ms.order.service.payment.PaymentRequest;
import com.ms.order.service.product.ProductClient;
import com.ms.order.service.reposistory.OrderLineReposistory;
import com.ms.order.service.reposistory.OrderReposistory;
import com.ms.order.service.request.response.OrderLineRequest;
import com.ms.order.service.request.response.OrderLineResponse;
import com.ms.order.service.request.response.OrderMapper;
import com.ms.order.service.request.response.OrderRequest;
import com.ms.order.service.request.response.OrderResponse;
import com.ms.order.service.request.response.PurchaseRequest;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final CustomerClient customerClient;

	private final ProductClient productClient;

	private final OrderReposistory repository;

	private final OrderLineReposistory lineReposistory;

	private final OrderMapper mapper;

	private final OrderLineService orderLineService;

	private final OrderProducer orderProducer;

	private final PaymentClient paymentClient;

	public Integer createOrder(@Valid OrderRequest request) {
		// 1
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

		var paymentRequest = new PaymentRequest(

				request.amount(), request.paymentMethod(), order.getId(), order.getReference(), customer);
		paymentClient.requestOrderPayment(paymentRequest);

		// 6

		orderProducer.sendOrderConfirmation(new OrderConfirmation(request.reference(), request.amount(),
				purchaseProducts, customer, request.paymentMethod()));

		return order.getId();
	}

	public List<OrderResponse> findAll() {

		List<OrderResponse> orders = repository.findAll().stream().map(mapper::fromOrder).collect(Collectors.toList());

		return orders;
	}

	public OrderResponse findByOrderId(Integer orderId) {

		OrderResponse order = repository.findById(orderId).map(mapper::fromOrder).orElseThrow(
				() -> new EntityNotFoundException(String.format("No order found with the provided Id: %d", orderId)));

		return order;
	}

	public List<OrderLineResponse> findAllOrderLines(Integer orderId) {
		List<OrderLineResponse> orderLines = lineReposistory.findAllByOrderId(orderId).stream()
				.map(mapper::toOrderLineResponse).collect(Collectors.toList());
		return orderLines;
	}

}
