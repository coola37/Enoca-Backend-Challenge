package com.yigitkula.enoca.backendchalange.service.impl;

import com.yigitkula.enoca.backendchalange.entity.Customer;
import com.yigitkula.enoca.backendchalange.entity.Order;
import com.yigitkula.enoca.backendchalange.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer addCustomer(String name, String email) {
        return null;
    }

    @Override
    public Customer getCustomer(Long id) {
        return null;
    }

    @Override
    public List<Order> getAllOrdersForCustomer(Long customerId) {
        return null;
    }
}
