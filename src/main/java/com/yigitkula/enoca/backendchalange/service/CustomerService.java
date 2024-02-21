package com.yigitkula.enoca.backendchalange.service;

import com.yigitkula.enoca.backendchalange.entity.Customer;
import com.yigitkula.enoca.backendchalange.entity.Order;


import java.util.List;

public interface CustomerService {

    public Customer addCustomer(String name, String email);
    public Customer getCustomer(Long id);
    public List<Order> getAllOrdersForCustomer(Long customerId);
}
