package com.yigitkula.enoca.backendchalange.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity(name = "orders")
@Data
public class Order extends BaseEntity {
    @ManyToOne
    @JsonBackReference
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderItem> orderItems;
    private double price;
}
