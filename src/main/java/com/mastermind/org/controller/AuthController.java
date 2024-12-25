package com.mastermind.org.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastermind.org.playload.Dto.ClientDto;
import com.mastermind.org.service.ClientService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	
	private final ClientService clientService ;
	
	public AuthController(ClientService clientService) {
		this.clientService = clientService ;
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<ClientDto> addClient(@RequestBody ClientDto clientDto) {
		return new ResponseEntity<ClientDto>(clientService.createClient(clientDto), HttpStatus.CREATED);
	}
	
	// methode pour le login
	
}
