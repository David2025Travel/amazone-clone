package com.mastermind.org.playload;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtRequest {

	/*
	 * classe permettant de login un utilisateur
	 */
	private String username;
	private String password ;
}
