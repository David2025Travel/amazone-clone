package com.mastermind.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastermind.org.entities.Review;

public interface ReviewRepo extends JpaRepository<Review, Long> {

}
