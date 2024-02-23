package com.yigitkula.enoca.backendchalange.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity(name = "carts")
@Data
public class Cart extends BaseEntity {
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<CartItem> cartItems;
}