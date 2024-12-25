package com.mastermind.org.playload.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ClientDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id ;
	
	
	private String name;
	
	
	private String email ;
	
	
	private String adresse ;
	
	
	
	private String password ;
}
