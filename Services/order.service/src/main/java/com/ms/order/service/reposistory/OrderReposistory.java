package com.ms.order.service.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.order.service.order.Order;

@Repository
public interface OrderReposistory extends JpaRepository<Order, Integer> {

}
