package com.ms.order.service.request.response;

public record OrderLineRequest(

		Integer id, Integer orderId, Integer productId, double quantity) {

}
