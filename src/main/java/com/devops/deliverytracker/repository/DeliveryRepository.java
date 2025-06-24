package com.devops.deliverytracker.repository;

import com.devops.deliverytracker.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
