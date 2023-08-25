package com.example.demo.service;

import com.example.demo.model.Order;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class MockDBOrderService {
    private List<Order> orders = new ArrayList<>();
    private long nextOrderId = 1;

    public Order createOrder(Order order) {
        order.setOrderId(nextOrderId++);
        orders.add(order);
        return order;
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }
}