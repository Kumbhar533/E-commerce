package com.ms.product.service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.product.service.request.response.productPurchaseRequest;
import com.ms.product.service.request.response.productPurchaseResponse;
import com.ms.product.service.request.response.productRequest;
import com.ms.product.service.request.response.productResponse;
import com.ms.product.service.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@PostMapping
	public ResponseEntity<?> createProduct(@RequestBody @Valid productRequest request) {

		return ResponseEntity.ok(productService.createProduct(request));

	}

	@PostMapping("/purchase")
	public ResponseEntity<List<productPurchaseResponse>> purchaseProduct(
			@RequestBody List<productPurchaseRequest> request) {

		List<productPurchaseResponse> products = productService.purchaseProducts(request);
		return ResponseEntity.ok(products);
	}

	@GetMapping("/{product-id}")
	public ResponseEntity<productResponse> findProductById(@PathVariable("product-id") Integer productId) {
		return ResponseEntity.ok(productService.findById(productId));
	}

	@GetMapping("/all")
	public ResponseEntity<List<productResponse>> findAllProducts() {
		return ResponseEntity.ok(productService.findAll());
	}

}
