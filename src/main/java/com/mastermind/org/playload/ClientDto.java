package com.mastermind.org.playload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ClientDto {

	@JsonProperty(access = Access.READ_ONLY)
	private long id ;
	
	@NotNull
	private String name;
	
	@NotNull
	private String email ;
	
	@NotNull
	private String adresse ;
	
	@NotNull
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password ;
}
