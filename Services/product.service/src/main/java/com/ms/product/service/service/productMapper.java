package com.ms.product.service.service;

import org.springframework.stereotype.Service;

import com.ms.product.service.category.Category;
import com.ms.product.service.product.Product;
import com.ms.product.service.request.response.productPurchaseResponse;
import com.ms.product.service.request.response.productRequest;
import com.ms.product.service.request.response.productResponse;

@Service
public class productMapper {

	public Product toProduct(productRequest requst) {

		return Product.builder().id(requst.id()).name(requst.name()).description(requst.description())
				.availableQuantity(requst.availableQuantity()).price(requst.price())
				.category(Category.builder().id(requst.categoryId()).build()).build();
	}

	public productResponse toProductResponse(Product product) {

		return new productResponse(product.getId(), product.getName(), product.getDescription(),
				product.getAvailableQuantity(), product.getPrice(), product.getCategory().getId(),
				product.getCategory().getName(), product.getCategory().getDescription()

		);
	}

	public productPurchaseResponse toPurchaseProductResponse(Product product, double quantity) {
		return new productPurchaseResponse(product.getId(), product.getName(), product.getDescription(),
				product.getPrice(), quantity);
	}

}
