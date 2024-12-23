package com.mastermind.org.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client extends User{

	
	
	@Column(nullable = false)
	private String adresse ;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role ;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST,  fetch = FetchType.LAZY)
	private List<Review> reviews = new ArrayList<>();
	
	public Client() {
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
