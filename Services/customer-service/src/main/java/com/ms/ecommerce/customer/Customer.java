package com.ms.ecommerce.customer;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document
@Builder
public class Customer {

	@Id
	private String id;

	private String firstName;

	private String lastName;

	private String email;

	private Address address;

}
