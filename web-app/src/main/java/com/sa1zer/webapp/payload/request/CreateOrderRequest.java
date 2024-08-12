package com.sa1zer.webapp.payload.request;

import io.swagger.v3.oas.annotations.Parameter;

public record CreateOrderRequest(@Parameter(description = "Id пользователя", required = true) Long userId,
                                 @Parameter(description = "Email пользователя", required = true) String desc) {
}
