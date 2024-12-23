package com.mastermind.org.playload;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtResponse {

	/*
	 * classe permettant de repondre a la demande d'authentification d'un user
	 */
	private String username ;
	private String token ;
}
