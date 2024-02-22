package com.yigitkula.enoca.backendchalange.service;

import com.yigitkula.enoca.backendchalange.entity.Customer;
import com.yigitkula.enoca.backendchalange.entity.Order;


import java.util.List;

public interface CustomerService {

    public Customer addCustomer(Customer customer);
    public Customer getCustomer(Long id);
    public Customer updateCustomer(Long id, Customer customer);
    public List<Order> getAllOrdersForCustomer(Long customerId);
}
