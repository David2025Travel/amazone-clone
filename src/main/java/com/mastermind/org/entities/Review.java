package com.mastermind.org.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reviews")

@Getter @Setter
public class Review {

	/*
	 * afficher les avis en attentes
	 * approuver les avis
	 * rejeter les avis avec une raison
	 * afficher les avis approuves
	 * notifications pour signalé les utilisateurs sur leur rewiew : approuvé ou rejetes
	 * permettre au utilisateurs de signaler un avis
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@Column(length = 500)
	private String comment;
	
	@Column(nullable = false)
	private int rating ;
	
	@Enumerated(EnumType.STRING)
	private ReviewStatus status ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id", nullable = false)
	private Book book ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id", nullable = false)
	private Client client ;
	
	public Review() {
		this.status = ReviewStatus.PENDING ;
	}
}
