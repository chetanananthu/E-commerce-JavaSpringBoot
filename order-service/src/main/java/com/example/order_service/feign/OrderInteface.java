package com.example.order_service.feign;

import com.example.order_service.model.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("PRODUCT-SERVICE")
public interface OrderInteface {
    @GetMapping("products/orders/{orderId}")
    public ResponseEntity<List<ProductDto>> getProductsByOrderId(@PathVariable("orderId") long orderId);
}
