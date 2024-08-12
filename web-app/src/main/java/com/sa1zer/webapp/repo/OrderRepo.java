package com.sa1zer.webapp.repo;

import com.sa1zer.webapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
