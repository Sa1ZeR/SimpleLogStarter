package com.sa1zer.webapp.payload.dto;

import com.sa1zer.webapp.entity.OrderStatus;
import lombok.Builder;

@Builder
public record OrderDto(Long id,
        String desc,
        OrderStatus status) {


}
