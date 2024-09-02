package com.ms.ecommerce.payment.entities;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Validated
public record Customer(

		String id, @NotNull(message = "FirstName is required") String firstName,
		@NotNull(message = "LastName is required") String LastName,

		@NotNull(message = "Email is required") @Email(message = "Email is not properly formatted") String email) {

}
