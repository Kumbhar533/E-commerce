package com.ms.ecommerce.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.ecommerce.payment.request.response.PaymentRequest;
import com.ms.ecommerce.payment.service.PaymentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

	private final PaymentService paymentService;

	public ResponseEntity<Integer> createPayment(@RequestBody @Valid PaymentRequest paymentRequest) {

		return ResponseEntity.ok(paymentService.createPayment(paymentRequest));
	}

}
