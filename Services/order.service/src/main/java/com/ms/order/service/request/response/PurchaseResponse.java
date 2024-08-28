package com.ms.order.service.request.response;

import java.math.BigDecimal;

public record PurchaseResponse(Integer productId, String name, String description, BigDecimal price, double quantity) {

}
