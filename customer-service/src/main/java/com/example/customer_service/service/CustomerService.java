package com.example.customer_service.service;

import com.example.customer_service.entity.Customer;
import com.example.customer_service.model.CustomerDto;
import com.example.customer_service.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDto = new ArrayList<>();
        customers.stream().forEach(customer -> {
            Customer entity = customer;
            CustomerDto pojo = new CustomerDto();
            pojo.setId(entity.getId());
            pojo.setFirstName(entity.getFirstName());
            pojo.setLastName(entity.getLastName());
            pojo.setEmail(entity.getEmail());
            pojo.setPhoneNumber(entity.getPhoneNumber());
            customerDto.add(pojo);
        });
        return customerDto;
    }

    public CustomerDto getCustomerById(long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer.get(), customerDto);
        return customerDto;
    }

    public CustomerDto addCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerRepository.save(customer);
        return customerDto;
    }

    public CustomerDto updateCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerRepository.save(customer);
        return customerDto;
    }

    public void deleteCustomer(long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        customerRepository.delete(customer.get());
    }
}
