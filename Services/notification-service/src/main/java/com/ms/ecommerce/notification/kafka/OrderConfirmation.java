package com.ms.ecommerce.notification.kafka;

import java.math.BigDecimal;
import java.util.List;

import com.ms.ecommerce.notification.customer.Customer;
import com.ms.ecommerce.notification.product.Product;

public record OrderConfirmation(

		String orderReference, BigDecimal amount,

		PaymentMethod paymentMethod,

		Customer customer,

		List<Product> products

) {

}
