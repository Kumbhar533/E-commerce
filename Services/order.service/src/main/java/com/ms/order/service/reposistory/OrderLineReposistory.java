package com.ms.order.service.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.order.service.orderline.OrderLine;

public interface OrderLineReposistory extends JpaRepository<OrderLine, Integer> {

}
