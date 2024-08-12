package com.sa1zer.webapp.payload.request;

import com.sa1zer.webapp.annotation.NotNull;
import com.sa1zer.webapp.entity.OrderStatus;
import io.swagger.v3.oas.annotations.Parameter;

public record UpdateOrderRequest(@Parameter(description = "Статус заказа", required = true) @NotNull OrderStatus status) {
}
