package com.yigitkula.enoca.backendchalange.controller;

import com.yigitkula.enoca.backendchalange.entity.Cart;
import com.yigitkula.enoca.backendchalange.entity.CartItem;
import com.yigitkula.enoca.backendchalange.entity.Customer;
import com.yigitkula.enoca.backendchalange.entity.Order;
import com.yigitkula.enoca.backendchalange.service.CartService;
import com.yigitkula.enoca.backendchalange.service.CustomerService;
import com.yigitkula.enoca.backendchalange.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    CartService cartService;
    @Autowired
    CustomerService customerService;
    @Autowired
    OrderService orderService;
    @PostMapping("/create")
    Customer addCustomer(@RequestBody Customer customer){
        Cart cart = new Cart();
        cart.setCartItems(Collections.emptyList());
        Cart cartForCustomer = cartService.createCart(cart);
        Customer customer1 = new Customer();
        customer1.setCart(cartForCustomer);
        customer1.setName(customer.getName());
        customer1.setOrders(customer.getOrders());
        customer1.setId(customer.getId());
        customer1.setEmail(customer.getEmail());
        return customerService.addCustomer(customer1);
    }
    @GetMapping("/{customerId}")
    Customer getCustomer(@PathVariable Long customerId){
        return customerService.getCustomer(customerId);
    }

    @PutMapping("/place-order/{customerId}")
    Customer placeOrder(@PathVariable Long customerId){
        Customer customer = customerService.getCustomer(customerId);
        orderService.placeOrder(customerId);
        return customer;
    }

    @GetMapping("/get-all-orders-for-customer/{customerId}")
    List<Order> getAllOrdersForCustomer(@PathVariable Long customerId){
        return customerService.getAllOrdersForCustomer(customerId);
    }

    @GetMapping("/get-order-for-code/{orderId}")
    Order getOrderForCode(@PathVariable Long orderId){
        return orderService.getOrderForCode(orderId);
    }
}
