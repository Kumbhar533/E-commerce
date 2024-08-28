package com.ms.order.service.request.response;

import java.math.BigDecimal;
import java.util.List;

import com.ms.order.service.order.PaymentMethod;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderRequest(

		Integer id, String reference,

		@Positive(message = "Order amount should be positive") BigDecimal amount,

		@NotNull(message = "Payment method sholud be precised") PaymentMethod paymentMethod,

		@NotNull(message = "Customer should be present") @NotBlank(message = "Customer should be present") @NotBlank(message = "Customer should be present") String customerId,

		@NotEmpty(message = "Customer should purchase atleast one product") List<PurchaseRequest> purchase

) {

}
