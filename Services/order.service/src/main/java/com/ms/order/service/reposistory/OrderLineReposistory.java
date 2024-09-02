package com.ms.order.service.reposistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.order.service.orderline.OrderLine;

public interface OrderLineReposistory extends JpaRepository<OrderLine, Integer> {

	List<OrderLine> findAllByOrderId(Integer orderId);

}
