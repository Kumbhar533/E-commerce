package com.ms.ecommerce.payment.notification;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationProducer {

	private final KafkaTemplate<String, PaymentNotification> kafkaTemplate;

	public void sendNotification(PaymentNotification notification) {
		log.info("Sending notification with body <>{}", notification);

		Message<PaymentNotification> message = MessageBuilder.withPayload(notification)
				.setHeader(KafkaHeaders.TOPIC, "payment-topic").build();

		kafkaTemplate.send(message);

	}

}
