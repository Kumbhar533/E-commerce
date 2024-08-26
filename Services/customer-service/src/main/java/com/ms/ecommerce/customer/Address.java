package com.ms.ecommerce.customer;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Validated
@Builder
public class Address {

	private String street;

	private String houseNo;

	private String zipCode;

}
