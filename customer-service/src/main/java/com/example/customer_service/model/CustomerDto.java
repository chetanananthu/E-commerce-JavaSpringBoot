package com.example.customer_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    List<OrderDto> orders;
}
