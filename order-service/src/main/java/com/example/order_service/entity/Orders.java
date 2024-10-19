package com.example.order_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Orders {
    @Id
    private long id;

    private long quanity;

    private long customerId;

    private long totalAmount;

    private String paymentStatus;

    private LocalDate orderDate;
}
