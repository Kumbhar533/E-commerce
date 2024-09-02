package com.ms.product.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.product.service.product.Product;

public interface productRepository extends JpaRepository<Product, Integer> {

	List<Product> findAllByIdInOrderById(List<Integer> productIds);

}
