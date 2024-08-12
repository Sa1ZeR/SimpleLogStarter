package com.sa1zer.webapp.mapper;

import com.sa1zer.webapp.entity.Order;
import com.sa1zer.webapp.payload.dto.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements Mapper<Order, OrderDto>{
    @Override
    public OrderDto map(Order from) {
        return OrderDto.builder()
                .desc(from.getDesc())
                .id(from.getId())
                .status(from.getStatus())
                .build();
    }
}
