package com.ms.ecommerce.notification.kafka;

import java.time.LocalDateTime;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ms.ecommerce.notification.Notification;
import com.ms.ecommerce.notification.NotificationType;
import com.ms.ecommerce.notification.email.EmailService;
import com.ms.ecommerce.notification.reposistory.NotificationReposistory;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationConsumer {

	private final NotificationReposistory notificationReposistory;

	private final EmailService emailService;

	@KafkaListener(topics = "payment-topic")
	public void consumePaymentSucessNotification(PaymentCofirmation cofirmation) throws MessagingException {

		log.info("Consuming the topic from payment-topic");
		notificationReposistory.save(new Notification().builder().type(NotificationType.PAYMENT_CONFIRMATION)
				.notificationDate(LocalDateTime.now()).paymentCofirmation(cofirmation).build());

		String customerName = cofirmation.customerFirstName() + " " + cofirmation.customerLastName();
		emailService.sendPaymentSucessfulEmail(cofirmation.customerEmail(), customerName, cofirmation.amount(),
				cofirmation.orderReference());
	}

	@KafkaListener(topics = "order-topic")
	public void consumeOrderCorfirmationNotification(OrderConfirmation cofirmation) throws MessagingException {

		log.info("Consuming the topic from payment-topic");
		notificationReposistory.save(new Notification().builder().type(NotificationType.ORDER_CONFIRMATION)
				.notificationDate(LocalDateTime.now()).confirmation(cofirmation).build());

		String customerName = cofirmation.customer().firstName() + " " + cofirmation.customer().lastName();
		emailService.sendOrderConfirmationEmail(cofirmation.customer().email(), customerName, cofirmation.amount(),
				cofirmation.orderReference(), cofirmation.products());

	}
}
