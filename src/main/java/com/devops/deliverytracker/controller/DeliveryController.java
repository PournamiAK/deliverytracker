package com.devops.deliverytracker.controller;

import com.devops.deliverytracker.model.Delivery;
import com.devops.deliverytracker.repository.DeliveryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    private final DeliveryRepository repository;

    public DeliveryController(DeliveryRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Delivery create(@RequestBody Delivery delivery) {
        return repository.save(delivery);
    }

    @GetMapping
    public List<Delivery> getAll() {
        return repository.findAll();
    }

    @GetMapping("/average-delay")
    public double averageDelay() {
        List<Delivery> deliveries = repository.findAll();
        return deliveries.stream()
                .mapToInt(Delivery::getDelayDays)
                .average()
                .orElse(0.0);
    }
}
