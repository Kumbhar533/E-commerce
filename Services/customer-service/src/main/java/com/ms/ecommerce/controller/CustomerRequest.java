package com.ms.ecommerce.controller;

import com.ms.ecommerce.customer.Address;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(String id, @NotNull(message = "firstName sholud be required") String firstName,
		@NotNull(message = "lastName sholud be required") String lastName,
		@NotNull(message = "email sholud be required") @Email(message = "please enter valid email") String email,
		Address address) {

}
