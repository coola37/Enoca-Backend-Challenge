package com.yigitkula.enoca.backendchalange.controller;

import com.yigitkula.enoca.backendchalange.entity.Cart;
import com.yigitkula.enoca.backendchalange.entity.CartItem;
import com.yigitkula.enoca.backendchalange.entity.Customer;
import com.yigitkula.enoca.backendchalange.service.CartService;
import com.yigitkula.enoca.backendchalange.service.CustomerService;
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
   /* @PutMapping("/{customerId}")
    Customer updateCustomer(@PathVariable Long customerId){
        customerService.updateCustomer()
    }*/
}
