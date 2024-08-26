package com.ms.product.service.request.response;

import java.math.BigDecimal;

public record productResponse(

		Integer id,

		String name,

		String description,

		double availableQuantity,

		BigDecimal price,

		Integer categoryId, String categoryName,

		String categoryDescription

) {

}
