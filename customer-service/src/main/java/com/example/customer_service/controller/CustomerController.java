package com.example.customer_service.controller;

import com.example.customer_service.model.CustomerDto;
import com.example.customer_service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    public CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        List<CustomerDto> customerDtos=customerService.getAllCustomers();
        return new ResponseEntity<>(customerDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getACustomerById(@PathVariable ("id") long id){
        CustomerDto customerDto=customerService.getCustomerById(id);
        return new ResponseEntity<>(customerDto,HttpStatus.OK);
    }
    @GetMapping("orders/{id}")
    public ResponseEntity<CustomerDto>getOrdersByCustomerId(@PathVariable("id")long id){
        CustomerDto customerDto=customerService.getOrdersByCustomerId(id);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto cutomer=customerService.addCustomer(customerDto);
        return new ResponseEntity<>(cutomer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto cutomer=customerService.addCustomer(customerDto);
        return new ResponseEntity<>(cutomer, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCustomer(long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
