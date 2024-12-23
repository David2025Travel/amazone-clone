package com.mastermind.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastermind.org.entities.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long> {

}
