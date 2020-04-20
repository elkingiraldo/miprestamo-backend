package com.miprestamo.apps.miprestamoapi.controllers;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miprestamo.apps.miprestamoapi.dtos.ClientDTO;
import com.miprestamo.apps.miprestamoapi.exception.APIServiceException;
import com.miprestamo.apps.miprestamoapi.services.ClientServiceImpl;

/**
 * Controller to manage clients in Mi Prestamo app
 * 
 * @author egiraldo
 *
 */
@RestController
@RequestMapping("/api/v1.0/clients")
public class ClientController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	private ClientServiceImpl clientService;

	/**
	 * This method takes GET API request for handling and passing it to correct
	 * service application layer for searching all current clients
	 * 
	 * @param locale, language the client wants to use
	 * @return {@link List<ClientDTO>}, a list with all clients found
	 * @throws APIServiceException
	 */
	@GetMapping
	public ResponseEntity<List<ClientDTO>> getAllClients(
			@RequestHeader(value = "locale", required = false) final String locale) {

		final String requestId = UUID.randomUUID().toString();
		LOGGER.info("[ClientController][getAllClients][" + requestId + "] Started.");

		final List<ClientDTO> listOfClients = clientService.getAllClients(requestId);

		LOGGER.info("[ClientController][getAllClients][" + requestId + "] finished.");
		return new ResponseEntity<List<ClientDTO>>(listOfClients, HttpStatus.OK);
	}

	/**
	 * This method takes POST API request for handling and passing it to correct
	 * service application layer for creating a new client.
	 * 
	 * @param client, client provided in order to create.
	 * @param locale, language the client wants to use
	 * @return {@link ClientDTO}, client saved in DB.
	 * @throws APIServiceException when something was wrong during the process
	 */
	@PostMapping
	public ResponseEntity<ClientDTO> post(@RequestBody final ClientDTO client,
			@RequestHeader(value = "locale", required = false) final String locale) throws APIServiceException {

		final String requestId = UUID.randomUUID().toString();
		LOGGER.info("[ClientController][post][" + requestId + "] Started.");

		final ClientDTO newClient = clientService.create(client, requestId);

		LOGGER.info("[ClientController][post][" + requestId + "] finished.");
		return new ResponseEntity<ClientDTO>(newClient, HttpStatus.CREATED);
	}

}
