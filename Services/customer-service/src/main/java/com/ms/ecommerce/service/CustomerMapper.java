package com.ms.ecommerce.service;

import org.springframework.stereotype.Service;

import com.ms.ecommerce.controller.CustomerRequest;
import com.ms.ecommerce.customer.Customer;
import com.ms.ecommerce.customer.CustomerResonse;

@Service
public class CustomerMapper {

	public Customer toCustomer(CustomerRequest customerRequest) {

		if (customerRequest == null) {
			return null;
		}

		return Customer.builder().firstName(customerRequest.firstName()).lastName(customerRequest.lastName())
				.email(customerRequest.email()).address(customerRequest.address()).build();
	}

	public CustomerResonse fromCustomer(Customer customer) {
		return new CustomerResonse(customer.getId(), customer.getFirstName(), customer.getLastName(),
				customer.getEmail(), customer.getAddress());
	}

}
