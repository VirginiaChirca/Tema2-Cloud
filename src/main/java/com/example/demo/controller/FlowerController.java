package com.example.demo.controller;

import com.example.demo.model.Flower;
import com.example.demo.model.Order;
import com.example.demo.service.FlowerService;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/flowers")
public class FlowerController {
    private final FlowerService flowerService;
    @GetMapping
    public List<Flower> getFlowers() {
        return flowerService.getFlowers();
    }

    @GetMapping("/{id}")
    public Flower getFlower(@PathVariable Long id) {
        return flowerService.getFlower(id);
    }

    @PostMapping
    public Flower createFlower(@RequestBody Flower flower) {
        return flowerService.createFlower(flower);
    }

    @PutMapping("/{id}")
    public Flower updateFlower(@PathVariable Long id, @RequestBody Flower flower) {
        return flowerService.updateFlower(id, flower);
    }

    @DeleteMapping("/{id}")
    public Flower deleteFlower(@PathVariable Long id) {
        return flowerService.deleteFlower(id);
    }
    @PostMapping("buy")
    public void buyFlower(@RequestParam("id") Long id, @RequestParam("quantity") int quantity) {
        flowerService.buyFlower(id, quantity);
    }
}
