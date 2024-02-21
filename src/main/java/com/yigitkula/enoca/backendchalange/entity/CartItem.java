package com.yigitkula.enoca.backendchalange.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class CartItem extends BaseEntity {
    @ManyToOne
    private Product product;
    private int quantity;
}
