package com.example.demo.service;

import com.example.demo.model.Flower;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
@Service
@RequestMapping("/api/v1/flower")
@RequiredArgsConstructor
public class FlowerService {
    private final MockDBService mockDBService;

    public List<Flower> getFlowers() {
        return mockDBService.getFlowers();
    }

    public Flower getFlower(Long id) {
        return mockDBService.getFlower(id);
    }

    public Flower createFlower(Flower flower) {
        return mockDBService.createFlower(flower);
    }

    public Flower updateFlower(Long id, Flower flower) {
        return mockDBService.updateFlower(id, flower);
    }

    public Flower buyFlower(Long id, int quantity) {
        return mockDBService.buyFlower(id, quantity);
    }

    public Flower deleteFlower(Long id) {
        return mockDBService.deleteFlower(id);
    }

}
