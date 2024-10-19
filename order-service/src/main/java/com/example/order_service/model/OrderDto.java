package com.example.order_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
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
