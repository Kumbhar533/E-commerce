package com.ms.ecommerce.payment.notification;

import java.math.BigDecimal;

import com.ms.ecommerce.payment.entities.PaymentMethod;

public record PaymentNotification(

		String orderReference,

		BigDecimal amount,

		PaymentMethod paymentMethod,

		String customerFirstName,

		String customerLastName,

		String customerEmail

)

{

}
