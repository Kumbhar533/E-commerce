package com.ms.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ms.ecommerce.controller.CustomerRequest;
import com.ms.ecommerce.customer.Customer;
import com.ms.ecommerce.customer.CustomerResonse;
import com.ms.ecommerce.exception.CustomerNotFoundException;
import com.ms.ecommerce.repository.CustomerRepository;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

	private final CustomerRepository customerRepo;

	private final CustomerMapper customerMapper;

	public Customer isCustomerPresent(String customerId) {
		Customer customer = customerRepo.findById(customerId).orElseThrow(
				() -> new CustomerNotFoundException(String.format("Customer not present with this %s", customerId)));

		if (customer != null) {
			return customer;
		} else {
			return null;
		}
	}

	public String createCustomer(CustomerRequest customerRequest) {
		var customer = customerRepo.save(customerMapper.toCustomer(customerRequest));
		log.info("{} is register successfully", customerRequest.firstName());
		return customer.getId();
	}

	public String updateCustomer(@Valid CustomerRequest customer) {
		var user = isCustomerPresent(customer.id());
		mergeCustomer(user, customer);

		return customer.id();
	}

	private void mergeCustomer(Customer user, @Valid CustomerRequest customer) {

		if (StringUtils.isNotBlank(customer.firstName())) {

			user.setFirstName(customer.firstName());
		}
		if (StringUtils.isNotBlank(customer.lastName())) {

			user.setLastName(customer.lastName());
		}
		if (StringUtils.isNotBlank(customer.email())) {

			user.setEmail(customer.email());
		}
		if (customer.address() != null) {

			user.setAddress(customer.address());
		}
	}

	public List<CustomerResonse> findAllCustomers() {
		return customerRepo.findAll().stream().map(customerMapper::fromCustomer).collect(Collectors.toList());
	}

	public Boolean isCustomerExist(String customerId) {

		return customerRepo.findById(customerId).isPresent();
	}

	public CustomerResonse findById(String customerId) {
		return customerRepo.findById(customerId).map(customerMapper::fromCustomer).orElseThrow(
				() -> new CustomerNotFoundException(String.format("No customer found with this Id %s", customerId)));
	}

	public void deletefindById(String customerId) {

		customerRepo.deleteById(customerId);
	}

}
