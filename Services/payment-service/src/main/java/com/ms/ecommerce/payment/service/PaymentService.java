package com.ms.ecommerce.payment.service;

import org.springframework.stereotype.Service;

import com.ms.ecommerce.payment.entities.Payment;
import com.ms.ecommerce.payment.entities.PaymentMapper;
import com.ms.ecommerce.payment.notification.NotificationProducer;
import com.ms.ecommerce.payment.notification.PaymentNotification;
import com.ms.ecommerce.payment.reposistory.PaymentReposistory;
import com.ms.ecommerce.payment.request.response.PaymentRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

	private final PaymentReposistory reposistory;

	private final PaymentMapper mapper;

	private final NotificationProducer notificationProducer;

	public Integer createPayment(@Valid PaymentRequest paymentRequest) {

		Payment payment = reposistory.save(mapper.toPayment(paymentRequest));

		notificationProducer.sendNotification(new PaymentNotification(paymentRequest.orderReference(),
				paymentRequest.amount(), paymentRequest.paymentMethod(), paymentRequest.customer().firstName(),
				paymentRequest.customer().LastName(), paymentRequest.customer().email()));

		return payment.getId();
	}

}
