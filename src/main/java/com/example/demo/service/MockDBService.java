package com.example.demo.service;

import com.example.demo.model.Flower;
import com.example.demo.model.Order;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class MockDBService {
    public List<Flower> flowers = new ArrayList<>();
    private final OrderService orderService;
    public MockDBService(OrderService orderService) {
        this.orderService = orderService;
    }
    public Flower getFlower(Long id) {
        for (Flower flower : flowers) {
            if (flower.getId().equals(id)) {
                return flower;
            }
        }
        return null;
    }

    public Flower createFlower(Flower flower) {
        flowers.add(flower);
        return flower;
    }

    public Flower updateFlower(Long id, Flower flower) {
        for (Flower t : flowers) {
            if (t.getId().equals(id)) {
                t.setName(flower.getName());
                t.setStock(flower.getStock());
                t.setPrice(flower.getPrice());
                return t;
            }
        }
        return null;
    }

    public Flower deleteFlower(Long id) {
        for (Flower flower : flowers) {
            if (flower.getId().equals(id)) {
                flowers.remove(flower);
                return flower;
            }
        }
        return null;
    }

    public Flower buyFlower(Long id, int quantity) {
        Flower flower = getFlower(id);
        if (flower != null && flower.getStock() >= quantity) {
            flower.setStock(flower.getStock() - quantity);

            Order order = new Order();
            order.setFlowerId(flower.getId());
            order.setQuantity(quantity);
            order.setPrice(flower.getPrice() * quantity);

            orderService.createOrder(order);

            return flower;
        }
        return null;
    }

}