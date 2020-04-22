package com.miprestamo.apps.miprestamoapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miprestamo.apps.miprestamoapi.dtos.BankDTO;
import com.miprestamo.apps.miprestamoapi.services.BankServiceImpl;

/**
 * Rest controller for getting current partner banks of Mi Prestamo
 * 
 * @author elkin.giraldo
 *
 */
@RestController
@RequestMapping("/api/v1.0/banks")
public class BankController {

	@Autowired
	private BankServiceImpl bankService;

	/**
	 * This method takes GET API request for handling and passing it to correct
	 * service application layer.
	 * 
	 * @param locale, language the client wants to use
	 * @return {@link List<BankDTO>}, a list of IDs found.
	 */
	@GetMapping
	public ResponseEntity<List<BankDTO>> getbanks(
			@RequestHeader(value = "locale", required = false) final String locale) {
		final List<BankDTO> allIBanks = bankService.retrieveAllBanks();
		return new ResponseEntity<List<BankDTO>>(allIBanks, HttpStatus.OK);
	}

}
