package com.yigitkula.enoca.backendchalange.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer extends BaseEntity {
    private String name;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
