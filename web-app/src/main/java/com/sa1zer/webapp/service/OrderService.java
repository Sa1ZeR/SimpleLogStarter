package com.sa1zer.webapp.service;

import com.sa1zer.webapp.entity.Order;
import com.sa1zer.webapp.exeption.EntityNotFoundException;
import com.sa1zer.webapp.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;

    @Transactional(readOnly = true)
    public Order findById(Long id) {
        return orderRepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Order with %s not found", id)));
    }

    @Transactional
    public Order save(Order order) {
        return orderRepo.save(order);
    }

    @Transactional
    public void delete(Order order) {
        orderRepo.delete(order);
    }

    @Transactional
    public void deleteById(Long id) {
        orderRepo.deleteById(id);
    }
}
