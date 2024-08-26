package com.ms.product.service.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ms.product.service.productRepository;
import com.ms.product.service.exception.ProductPurchaseException;
import com.ms.product.service.product.Product;
import com.ms.product.service.request.response.productPurchaseRequest;
import com.ms.product.service.request.response.productPurchaseResponse;
import com.ms.product.service.request.response.productRequest;
import com.ms.product.service.request.response.productResponse;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final productRepository repository;

	private final productMapper mapper;

	public Integer createProduct(productRequest request) {

		Product product = mapper.toProduct(request);

		return repository.save(product).getId();
	}

	public List<productPurchaseResponse> purchaseProducts(List<productPurchaseRequest> requests) {

		var productIds = requests.stream().map(productPurchaseRequest::productId).toList();

		var storeProducts = repository.findAllByIdInOrderById(productIds);

		if (storeProducts.size() != productIds.size()) {

			throw new ProductPurchaseException("One or More products are not available");
		}

		var storedRequest = requests.stream().sorted(Comparator.comparing(productPurchaseRequest::productId)).toList();

		var purchaseProducts = new ArrayList<productPurchaseResponse>();
		for (int i = 0; i < storeProducts.size(); i++) {

			var product = storeProducts.get(i);
			var productRequest = storedRequest.get(i);

			if (productRequest.quantity() > product.getAvailableQuantity()) {

				throw new ProductPurchaseException("Out of Stock " + productRequest.quantity());
			}

			var NewAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();

			product.setAvailableQuantity(NewAvailableQuantity);
			repository.save(product);

			purchaseProducts.add(mapper.toPurchaseProductResponse(product, productRequest.quantity()));

		}

		return purchaseProducts;
	}

	public productResponse findById(Integer productId) {

		productResponse response = repository.findById(productId).map(mapper::toProductResponse)
				.orElseThrow(() -> new EntityNotFoundException("Product not found for this Id " + productId));

		return response;
	}

	public List<productResponse> findAll() {

		return repository.findAll().stream().map(mapper::toProductResponse).collect(Collectors.toList());
	}

}
