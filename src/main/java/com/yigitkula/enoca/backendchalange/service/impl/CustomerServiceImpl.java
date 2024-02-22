package com.yigitkula.enoca.backendchalange.service.impl;

import com.yigitkula.enoca.backendchalange.entity.*;
import com.yigitkula.enoca.backendchalange.repository.CartRepository;
import com.yigitkula.enoca.backendchalange.repository.CustomerRepository;
import com.yigitkula.enoca.backendchalange.repository.OrderRepository;
import com.yigitkula.enoca.backendchalange.service.CartService;
import com.yigitkula.enoca.backendchalange.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartService cartService;
    @Autowired
    CartRepository cartRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Order> getAllOrdersForCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        return customer.getOrders();
    }


}




