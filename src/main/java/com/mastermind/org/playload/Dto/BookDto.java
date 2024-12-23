package com.mastermind.org.playload.Dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BookDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
    private String title;
    
    private String subtitle;
    
    private String description;
    
    private String author;
    
    private LocalDate parution;
    
    private double inLinePrice;
    
    private double printPrice;
    
    private String imagePath;
    
    private int totalPages;
}
