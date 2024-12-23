package com.mastermind.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastermind.org.entities.Book;

public interface BookRepo extends JpaRepository<Book, Long> {

}
