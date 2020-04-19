package com.miprestamo.apps.miprestamoapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miprestamo.apps.miprestamoapi.dtos.ClientDTO;
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

	@Autowired
	private ClientServiceImpl clientService;

	@GetMapping
	public ResponseEntity<List<ClientDTO>> getAllClients() {

		final List<ClientDTO> listOfClients = clientService.getAllClients();

		return new ResponseEntity<List<ClientDTO>>(listOfClients, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ClientDTO> post(@RequestBody final ClientDTO client) {

		final ClientDTO newClient = clientService.create(client);

		return new ResponseEntity<ClientDTO>(newClient, HttpStatus.CREATED);
	}

}
