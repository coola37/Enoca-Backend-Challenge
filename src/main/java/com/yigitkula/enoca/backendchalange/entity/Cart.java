package com.yigitkula.enoca.backendchalange.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity(name = "carts")
@Data
public class Cart extends BaseEntity {

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> cartItems;
}
