package com.mastermind.org.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mastermind.org.entities.Client;
import com.mastermind.org.playload.Dto.ClientDto;
import com.mastermind.org.repository.ClientRepo;
import com.mastermind.org.service.ClientService;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

	private final ClientRepo clientRepo ;
	
	private final ModelMapper mapper ;
	
	private  final PasswordEncoder passwordEncoder ;
	
	public ClientServiceImpl(ClientRepo clientRepo, ModelMapper mapper, PasswordEncoder passwordEncoder) {
		
		this.clientRepo = clientRepo;
		this.mapper=mapper;
		this.passwordEncoder = passwordEncoder ;
		
    }
	
	
	@Override
	public ClientDto createClient(ClientDto clientDto) {
		
		
		Client client = mapper.map(clientDto, Client.class);
		
		var clientSaveOpt = clientRepo.findByEmail(clientDto.getEmail()) ;
		
		if(clientSaveOpt.isEmpty()) {
			//client.setId(0L);
			client.setPassword(passwordEncoder.encode(clientDto.getPassword()));
			return mapper.map(clientRepo.save(client),ClientDto.class );
		}
		throw new RuntimeException("This email exist");
	}

	@Override
	public ClientDto updateClient(ClientDto clientDto, long id) {
		
		// verifier si son compte est bloqué
		
		var clientUpdate = clientRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("User don't exist"));
		
		
		
		clientUpdate.setEmail(clientDto.getEmail());
		clientUpdate.setName(clientDto.getName());
		clientUpdate.setPassword(passwordEncoder.encode(clientDto.getPassword()));
		clientUpdate.setAdresse(clientDto.getAdresse());
		
		var clientSave = clientRepo.save(clientUpdate);
		return mapper.map(clientSave, ClientDto.class);
	}

	@Override
	public void deleteClient(long id) {
		
		clientRepo.deleteById(id);
	}

	@Override
	public List<ClientDto> listClients() {
		
		return this.clientRepo
					.findAll()
					.stream()
					.map(this::convertToDto)
					.toList();
	}
	
	private ClientDto convertToDto(Client client) {
		
		return mapper.map(client, ClientDto.class);
	}

}
