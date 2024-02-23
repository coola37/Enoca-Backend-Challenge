package com.yigitkula.enoca.backendchalange.service.impl;

import com.yigitkula.enoca.backendchalange.entity.*;
import com.yigitkula.enoca.backendchalange.repository.CartRepository;
import com.yigitkula.enoca.backendchalange.repository.CustomerRepository;
import com.yigitkula.enoca.backendchalange.repository.OrderRepository;
import com.yigitkula.enoca.backendchalange.repository.ProductRepository;
import com.yigitkula.enoca.backendchalange.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Override
    public Order placeOrder(Long customerId) {

        Customer customer = customerRepository.findById(customerId).orElseThrow();
        Order order = cartConvertToOrder(customer.getCart());
        order.setCustomer(customer);
        List<OrderItem> orders = order.getOrderItems();

        Double price = 0.0;
        for(OrderItem item : orders){
            price = price + item.getPrice();
        }
        order.setPrice(price);
        orderRepository.save(order);

        List<Order> orderList = customer.getOrders();
        orderList.add(order);
        customer.setOrders(orderList);

        Cart cart = customer.getCart();
        cart.setCartItems(Collections.emptyList());
        customer.setCart(cart);
        customerRepository.save(customer);

        List<OrderItem> orderItems = order.getOrderItems();
        for(OrderItem item : orderItems){
            Product product = productRepository.findById(item.getProduct().getId()).orElseThrow();
            product.setInStock(product.getInStock() - item.getQuantity());
            productRepository.save(product);
        }
        return order;
    }

    @Override
    public Order getOrderForCode(Long id) {
        return orderRepository.findById(id).orElseThrow();
    }

    private Order cartConvertToOrder(Cart cart){
        Order order = new Order();
        List<CartItem> cartItems = cart.getCartItems();
        List<OrderItem> orderItems = new ArrayList<>();
        for(int i=0; i < cartItems.size(); i++){
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(cartItems.get(i).getProduct());
            orderItem.setQuantity(cartItems.get(i).getQuantity());
            orderItem.setPrice(cartItems.get(i).getProduct().getPrice() * cartItems.get(i).getQuantity());
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
        return order;
    }
}