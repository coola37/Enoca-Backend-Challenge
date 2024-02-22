package com.yigitkula.enoca.backendchalange.repository;

import com.yigitkula.enoca.backendchalange.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
