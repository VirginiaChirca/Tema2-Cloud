package com.example.demo.service;

import com.example.demo.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final MockDBOrderService mockDBOrderService;

    public Order createOrder(Order order) {
        return mockDBOrderService.createOrder(order);
    }

    public List<Order> getOrders() {
        return mockDBOrderService.getOrders();
    }
}
