package com.example.order_service.controller;

import com.example.order_service.model.OrderDto;
import com.example.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        List<OrderDto>orderDtos=orderService.getAllOrders();
        return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getAOrder(@PathVariable("id") long id){
        OrderDto orderDto=orderService.getAOrder(id);
        return new ResponseEntity<>(orderDto,HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<List<OrderDto>> getOrdersByCustomerId(@PathVariable("id")long id){
        List<OrderDto> orders=orderService.getOrdersByCustomerId(id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto){
        OrderDto order=orderService.addOrder(orderDto);
        return new ResponseEntity<>(order,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderDto orderDto){
        OrderDto order=orderService.addOrder(orderDto);
        return new ResponseEntity<>(order,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") long id){
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
