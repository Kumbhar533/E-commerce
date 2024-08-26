package com.ms.ecommerce.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ms.ecommerce.customer.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

}
