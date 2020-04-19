package com.miprestamo.apps.miprestamoapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miprestamo.apps.miprestamoapi.dtos.ClientDTO;
import com.miprestamo.apps.miprestamoapi.entities.Client;
import com.miprestamo.apps.miprestamoapi.repositories.ClientRepository;
import com.miprestamo.apps.miprestamoapi.services.converters.ClientConverterService;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ClientConverterService clientConverterService;

	public ClientDTO getClientById(final String id) {
		final Optional<Client> optionalClient = clientRepository.findById(id);
		if (optionalClient.isPresent()) {
			return clientConverterService.toDTO(optionalClient.get());
		}

		return null;
	}

	@Override
	public List<ClientDTO> getAllClients() {
		List<Client> clientList = clientRepository.findAll();
		return clientConverterService.toDtos(clientList);
	}

	@Override
	public ClientDTO create(ClientDTO client) {
//		clientRepository.save();
		return null;
	}

	

}
