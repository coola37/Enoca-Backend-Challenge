package com.yigitkula.enoca.backendchalange.repository;

import com.yigitkula.enoca.backendchalange.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
