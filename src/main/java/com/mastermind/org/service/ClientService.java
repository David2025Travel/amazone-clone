package com.mastermind.org.service;

import java.util.List;

import com.mastermind.org.playload.Dto.ClientDto;

public interface ClientService {

	ClientDto createClient(ClientDto clientDto);
	ClientDto updateClient(ClientDto clientDto, long id);
	void deleteClient(long id);
	List<ClientDto> listClients();
}
