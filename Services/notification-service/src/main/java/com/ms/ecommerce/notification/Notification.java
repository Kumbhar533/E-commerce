package com.ms.ecommerce.notification;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ms.ecommerce.notification.kafka.OrderConfirmation;
import com.ms.ecommerce.notification.kafka.PaymentCofirmation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Document
@Setter
@Getter
@Builder
public class Notification {

	@Id
	private String id;

	private NotificationType type;

	private LocalDateTime notificationDate;

	private OrderConfirmation confirmation;

	private PaymentCofirmation paymentCofirmation;

}
