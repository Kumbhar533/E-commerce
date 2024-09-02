package com.ms.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.ecommerce.customer.CustomerResonse;
import com.ms.ecommerce.service.CustomerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerService customerService;

	@PostMapping
	public ResponseEntity<?> addCustomer(@Valid @RequestBody CustomerRequest customer) {

		return ResponseEntity.ok(customerService.createCustomer(customer));
	}

	@PutMapping
	public ResponseEntity<?> updateCustomer(@Valid @RequestBody CustomerRequest customer) {

		customerService.updateCustomer(customer);

		return ResponseEntity.accepted().build();
	}

	@GetMapping
	public ResponseEntity<List<CustomerResonse>> findAll() {

		return ResponseEntity.ok(customerService.findAllCustomers());
	}

	@GetMapping("/exist/{customer-id}")
	public ResponseEntity<Boolean> isExistCustomer(@PathVariable("customer-id") String customerId) {

		return ResponseEntity.ok(customerService.isCustomerExist(customerId));
	}

	@GetMapping("/{customer-id}")
	public ResponseEntity<CustomerResonse> findCustomerById(@PathVariable("customer-id") String customerId) {

		return ResponseEntity.ok(customerService.findById(customerId));
	}

	@DeleteMapping("/{customer-id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable("customer-id") String customerId) {

		customerService.deletefindById(customerId);
		return ResponseEntity.ok("Customer deleted Successfully");
	}

}
