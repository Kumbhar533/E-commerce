package com.ms.product.service.request.response;

import jakarta.validation.constraints.NotNull;

public record productPurchaseRequest(

		@NotNull(message = "Product is mandatory") Integer productId,
		@NotNull(message = "Quantity is mandatory") double quantity) {

}
