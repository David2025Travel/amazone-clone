package com.mastermind.org.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@Column(nullable = false)
	private String title ;
	
	@Column(nullable = false)
	private String subtitle ;
	
	@Column(nullable = false)
	private String description ;
	
	@Column(nullable = false)
	private String author ;
	
	@Column(nullable = false)
	private LocalDate parution ;
	
	@Column(nullable = false)
	private double inLinePrice ;
	
	@Column(nullable = false)
	private double printPrice ;
	
	@Column(nullable = false)
	private String imagePath ;
	
	@Column(nullable = false)
	private int totalPages ;
	
	@ManyToOne
	private Category category ;
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Review> reviews = new ArrayList<>();
	
	public void addReviews(Review review) {
		reviews.add(review);
		review.setBook(this);
	}
	
	public void removeReviews(Review review) {
		reviews.remove(review);
		review.setBook(null);
	}
}
