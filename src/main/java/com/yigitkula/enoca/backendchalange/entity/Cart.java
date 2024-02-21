package com.yigitkula.enoca.backendchalange.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cart extends BaseEntity {
    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> cartItems;
}
