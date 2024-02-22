package com.yigitkula.enoca.backendchalange.service;

import com.yigitkula.enoca.backendchalange.entity.Order;

public interface OrderService {
    public Order placeOrder(Long customerId);
    public Order getOrderForCode(Long id);
}
