package com.yigitkula.enoca.backendchalange.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Product extends BaseEntity{
    private String name;
    private double price;
    private int inStock;
}
