package com.mastermind.org.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Admin extends User {

	/*
	 * gerer les utilisateurs
	 * gerer les avis
	 * gerer les statistiques
	 */
	@Column(nullable = false)
    private boolean active; 

    @Column(nullable = true)
    private LocalDateTime lastLogin; 

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;  


    public Admin() {
        super(); 
        this.active = true; 
        this.role = Role.ADMIN;
    }

    
    public void updateLastLogin() {
        this.lastLogin = LocalDateTime.now();
    }
}
