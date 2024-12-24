package com.mastermind.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastermind.org.entities.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {

}
