package com.mastermind.org.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity  @Getter @Setter @ToString
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	
	private String name ;
	
	
	@Column(unique = true)
	private String email ;
	
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password ;
	
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
