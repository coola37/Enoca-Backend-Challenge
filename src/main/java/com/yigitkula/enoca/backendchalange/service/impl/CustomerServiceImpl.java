package com.yigitkula.enoca.backendchalange.service.impl;

import com.yigitkula.enoca.backendchalange.entity.Customer;
import com.yigitkula.enoca.backendchalange.entity.Order;
import com.yigitkula.enoca.backendchalange.repository.CustomerRepository;
import com.yigitkula.enoca.backendchalange.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repo;

    @Override
    public Customer addCustomer(Customer customer) {
        return repo.save(customer);
    }

    @Override
    public Customer getCustomer(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer oldCustomer = repo.findById(id).orElseThrow();
        //oldCustomer.setCart();
        return null;
    }

    @Override
    public List<Order> getAllOrdersForCustomer(Long customerId) {

        return null;
    }
}
