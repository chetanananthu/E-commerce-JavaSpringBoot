package com.example.customer_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Customer {

    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
