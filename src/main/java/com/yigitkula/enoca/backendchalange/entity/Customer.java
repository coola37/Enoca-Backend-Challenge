package com.yigitkula.enoca.backendchalange.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Customer extends BaseEntity {
    private String name;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;
    @OneToMany(mappedBy = "customer")
    @Column(name = "product_id")
    private List<Order> orders;
}
