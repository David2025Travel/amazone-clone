package com.mastermind.org.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastermind.org.playload.Dto.ClientDto;
import com.mastermind.org.service.ClientService;


@RestController
@RequestMapping(value = "/api/v1/users")
public class ClientController {

	private final ClientService clientService ;
	
	public ClientController(ClientService clientService) {
		
		this.clientService = clientService ;
	}
	
	
	@GetMapping
	public List<ClientDto> clientsList(){
		return clientService.listClients();
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<ClientDto> updateClient(@RequestBody ClientDto clientDto, @PathVariable("id") long id){
		return new  ResponseEntity<ClientDto>(clientService.updateClient(clientDto, id), HttpStatus.OK);
	}
	
	// autorisation admin
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
		clientService.deleteClient(id);
		return new ResponseEntity<String>("Succes", HttpStatus.OK);
	}
}
