package com.example.customer_service.feign;

import com.example.customer_service.model.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("ORDER-SERVICE")
public interface CustomerInterface {

    @GetMapping("orders/customers/{id}")
    public ResponseEntity<List<OrderDto>> getOrdersByCustomerId(@PathVariable("id")long id);
}
