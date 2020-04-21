package com.miprestamo.apps.miprestamoapi.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miprestamo.apps.miprestamoapi.dtos.ClientDTO;
import com.miprestamo.apps.miprestamoapi.entities.Client;
import com.miprestamo.apps.miprestamoapi.exception.APIServiceErrorCodes;
import com.miprestamo.apps.miprestamoapi.exception.APIServiceException;
import com.miprestamo.apps.miprestamoapi.repositories.ClientRepository;
import com.miprestamo.apps.miprestamoapi.services.converters.ClientConverterService;
import com.miprestamo.apps.miprestamoapi.services.validation.ClientValidationService;

/**
 * Service implementation for handling all client services
 * 
 * @author egiraldo
 *
 */
@Service
public class ClientServiceImpl implements IClientService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

	private static final Function<Integer, String> REQUESTED_ID_MSG = id -> "ID: " + id;

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ClientConverterService clientConverterService;
	@Autowired
	private ClientValidationService clientValidationService;

	@Override
	public List<ClientDTO> getAllClients(final String requestId) {
		LOGGER.info("[ClientServiceImpl][getAllClients][" + requestId + "] Started.");

		final List<Client> clientList = clientRepository.findAll();
		final List<ClientDTO> dtos = clientConverterService.toDtos(clientList, requestId);

		LOGGER.info("[ClientServiceImpl][getAllClients][" + requestId + "] Finished.");
		return dtos;
	}

	@Override
	public ClientDTO getClientById(final int id) throws APIServiceException {
		final Optional<Client> optionalClient = clientRepository.findById(id);
		if (optionalClient.isPresent()) {
			return clientConverterService.toDTO(optionalClient.get());
		}
		throw new APIServiceException(REQUESTED_ID_MSG.apply(id), APIServiceErrorCodes.CLIENT_NOT_FOUND_EXCEPTION);
	}

	@Override
	@Transactional
	public ClientDTO create(final ClientDTO client, final String requestId) throws APIServiceException {
		LOGGER.info("[ClientServiceImpl][create][" + requestId + "] Started.");

		clientValidationService.validateCreation(client, requestId);
		clientValidationService.autocompleteInfo(client, requestId);

		final Client newClientEntity = clientRepository.save(clientConverterService.toEntity(client, requestId));

		final ClientDTO newClientDto = clientConverterService.toDTO(newClientEntity);
		LOGGER.info("[ClientServiceImpl][create][" + requestId + "] Finished. New client created with ID: "
				+ newClientEntity.getId());
		return newClientDto;
	}

	@Override
	@Transactional
	public ClientDTO update(final ClientDTO client, final String requestId) throws APIServiceException {
		LOGGER.info("[ClientServiceImpl][update][" + requestId + "] Started.");

		clientValidationService.validateUpdate(client, requestId);

		final Client updatedClientEntity = clientRepository.save(clientConverterService.toEntity(client, requestId));

		final ClientDTO newClientDto = clientConverterService.toDTO(updatedClientEntity);
		LOGGER.info("[ClientServiceImpl][update][" + requestId + "] Finished. client updated with ID: "
				+ updatedClientEntity.getId());
		return newClientDto;
	}

}
