package com.mastermind.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastermind.org.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
