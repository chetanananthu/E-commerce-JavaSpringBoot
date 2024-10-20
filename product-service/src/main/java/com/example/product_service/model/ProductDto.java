package com.example.product_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductDto {
    private long id;
    private String name;
    private int price;
    private int quantity;
    private long orderId;
}
