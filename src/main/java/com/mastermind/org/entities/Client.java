package com.mastermind.org.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "clients") @ToString
@Getter @Setter
public class Client{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	
	private String name ;
	
	
	@Column(unique = true)
	private String email ;
	
	
	
	private String password ;
	
	@Column(nullable = false)
	private String adresse ;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role ;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST,  fetch = FetchType.LAZY)
	private List<Review> reviews = new ArrayList<>();
	
	public Client() {
		super();
		this.role= Role.USER ;
	}
	public void addReviews(Review review) {
		reviews.add(review);
		review.setClient(this);
	}
	
	public void removeReviews(Review review) {
		reviews.remove(review);
		review.setClient(null);
	}
}
