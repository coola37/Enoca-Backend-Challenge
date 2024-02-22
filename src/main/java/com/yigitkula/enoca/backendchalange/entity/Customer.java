package com.yigitkula.enoca.backendchalange.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    private Cart cart;
    @OneToMany(mappedBy = "customer")
    @Column(name = "product_id")
    @JsonManagedReference
    private List<Order> orders;
}
