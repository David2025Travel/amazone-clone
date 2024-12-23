package com.mastermind.org.playload.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ReviewDto {

	/*
	 * besoin de fournir :
	 *  -- l'id du book sur lequelle on fait le commentaire
	 *  -- l'email du client qui le fait
	 */
	private int id ;
	
	private String comment ;
	
	private int rating ;
	
	private String email ;
}
