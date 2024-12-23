package com.mastermind.org.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter @Setter
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	
	private String title ;
	
	
	private String subtitle ;
	
	
	private String description ;
	
	
	private String author ;
	
	
	private LocalDate parution ;
	
	
	private double inLinePrice ;
	
	
	private double printPrice ;
	
	
	private String imagePath ;
	
	
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
