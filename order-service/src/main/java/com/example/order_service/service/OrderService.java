package com.example.order_service.service;

import com.example.order_service.entity.Orders;
import com.example.order_service.model.OrderDto;
import com.example.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<OrderDto> getAllOrders(){
        List<Orders> orders =orderRepository.findAll();
        List<OrderDto>orderDtos=new ArrayList<>();
        orders.stream().forEach(order->{
            OrderDto orderDto=new OrderDto();
            orderDto.setId(order.getId());
            orderDto.setQuanity(order.getQuanity());
            orderDto.setCustomerId(order.getCustomerId());
            orderDto.setTotalAmount(order.getTotalAmount());
            orderDto.setPaymentStatus(order.getPaymentStatus());
            orderDto.setOrderDate(order.getOrderDate());
            orderDtos.add(orderDto);
        });
        return orderDtos;

    }

    public OrderDto getAOrder(long id){
        Optional<Orders> order=orderRepository.findById(id);
        OrderDto orderDto=new OrderDto();
        orderDto.setId(order.get().getId());
        orderDto.setQuanity(order.get().getQuanity());
        orderDto.setCustomerId(order.get().getCustomerId());
        orderDto.setTotalAmount(order.get().getTotalAmount());
        orderDto.setPaymentStatus(order.get().getPaymentStatus());
        orderDto.setOrderDate(order.get().getOrderDate());
        return orderDto;
    }

    public OrderDto addOrder(OrderDto orderDto){
        System.out.println(orderDto.toString());
        Orders order=new Orders();

        order.setId(orderDto.getId());
        order.setQuanity(orderDto.getQuanity());
        order.setCustomerId(orderDto.getCustomerId());
        order.setTotalAmount(orderDto.getTotalAmount());
        order.setPaymentStatus(orderDto.getPaymentStatus());
        order.setOrderDate(orderDto.getOrderDate());

        orderRepository.saveAndFlush(order);
        return orderDto;
    }

    public OrderDto updateOrder(OrderDto orderDto){
        Orders order=new Orders();
        order.setId(orderDto.getId());
        order.setQuanity(orderDto.getQuanity());
        order.setCustomerId(orderDto.getCustomerId());
        order.setTotalAmount(orderDto.getTotalAmount());
        order.setPaymentStatus(orderDto.getPaymentStatus());
        order.setOrderDate(orderDto.getOrderDate());
        orderRepository.saveAndFlush(order);
        return orderDto;
    }

    public void deleteOrder(long id){
        orderRepository.deleteById(id);
    }



}
