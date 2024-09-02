package com.ms.ecommerce.payment.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.ecommerce.payment.entities.Payment;

public interface PaymentReposistory extends JpaRepository<Payment, Integer> {

}
