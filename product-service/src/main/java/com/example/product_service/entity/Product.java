package com.example.product_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Product {

    @Id
    private long id;
    private String name;
    private int price;
    private int quantity;
    private int orderId;
}
