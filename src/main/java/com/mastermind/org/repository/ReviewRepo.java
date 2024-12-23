package com.mastermind.org.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mastermind.org.entities.Review;

public interface ReviewRepo extends JpaRepository<Review, Long> {

	Page<Review> findByBookId(Long bookId, Pageable pageable);
}
