package com.ms.product.service.request.response;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public record productRequest(

		Integer id,

		@NotNull(message = "Product name is required") String name,
		@NotNull(message = "Product description is required") String description,
		@NotNull(message = "Avaiable Products should be positive") double availableQuantity,
		@NotNull(message = "price should be positive") BigDecimal price,
		@NotNull(message = "category id sholud be positive") Integer categoryId

) {

}
