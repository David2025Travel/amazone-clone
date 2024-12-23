package com.mastermind.org.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastermind.org.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

	Optional<Category> findByName(String name);
}
