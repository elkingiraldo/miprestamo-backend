package com.miprestamo.apps.miprestamoapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miprestamo.apps.miprestamoapi.dtos.ClientDTO;
import com.miprestamo.apps.miprestamoapi.entities.Client;
import com.miprestamo.apps.miprestamoapi.repositories.ClientRepository;
import com.miprestamo.apps.miprestamoapi.services.converters.ClientConverterService;

/**
 * Service implementation for handling all client services
 * 
 * @author egiraldo
 *
 */
@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ClientConverterService clientConverterService;

	@Override
	public List<ClientDTO> getAllClients() {
		final List<Client> clientList = clientRepository.findAll();
		return clientConverterService.toDtos(clientList);
	}

	@Override
	public ClientDTO getClientById(final int id) {
		final Optional<Client> optionalClient = clientRepository.findById(id);
		if (optionalClient.isPresent()) {
			return clientConverterService.toDTO(optionalClient.get());
		}
		// TODO
		return null;
	}

	@Override
	public ClientDTO create(final ClientDTO client) {
//		clientRepository.save();
		return null;
	}

}
