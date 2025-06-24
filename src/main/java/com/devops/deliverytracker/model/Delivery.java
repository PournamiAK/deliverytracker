package com.devops.deliverytracker.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String packageId;
    private String customerName;
    private int expectedDays;
    private int actualDays;

    public int getDelayDays() {
        return actualDays - expectedDays;
    }
}
