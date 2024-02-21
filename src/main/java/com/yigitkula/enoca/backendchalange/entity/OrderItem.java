package com.yigitkula.enoca.backendchalange.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity(name = "order_items")
@Data
public class OrderItem extends BaseEntity {
    @ManyToOne
    private Product product;
    private int quantity;
    private double price;
}
