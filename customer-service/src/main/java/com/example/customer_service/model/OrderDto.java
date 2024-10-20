package com.example.customer_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    private long id;

    private long quanity;

    private long customerId;

    private long totalAmount;

    private String paymentStatus;

    private LocalDate orderDate;

    List<ProductDto> products;
}
