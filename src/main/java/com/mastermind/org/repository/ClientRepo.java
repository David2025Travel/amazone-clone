package com.mastermind.org.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastermind.org.entities.Client;


public interface ClientRepo extends JpaRepository<Client, Long> {

	Optional<Client> findByEmail(String email);
}
