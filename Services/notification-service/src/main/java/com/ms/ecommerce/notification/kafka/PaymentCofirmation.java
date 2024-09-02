package com.ms.ecommerce.notification.kafka;

import java.math.BigDecimal;

public record PaymentCofirmation(

		String orderReference,

		BigDecimal amount,

		PaymentMethod paymentMethod,

		String customerFirstName,

		String customerLastName,

		String customerEmail

) {

}
