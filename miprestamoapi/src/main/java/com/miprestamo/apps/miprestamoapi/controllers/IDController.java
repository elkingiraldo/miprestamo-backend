package com.miprestamo.apps.miprestamoapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miprestamo.apps.miprestamoapi.dtos.IdentificationDocumentDTO;
import com.miprestamo.apps.miprestamoapi.services.IDServiceImpl;

/**
 * Rest controller for getting current IDs that Mi Prestamo has available
 * 
 * @author egiraldo
 *
 */
@RestController
@RequestMapping("/api/v1.0/ids")
public class IDController {

	@Autowired
	private IDServiceImpl idService;

	/**
	 * This method takes GET API request for handling and passing it to correct
	 * service application layer.
	 * 
	 * @param locale, language the client wants to use
	 * @return {@link List<IdentificationDocumentDTO>}, a list of IDs found.
	 */
	@GetMapping
	public ResponseEntity<List<IdentificationDocumentDTO>> getDocumentsType(
			@RequestHeader(value = "locale", required = false) final String locale) {
		final List<IdentificationDocumentDTO> allIDs = idService.retrieveAllDocumentsType();
		return new ResponseEntity<List<IdentificationDocumentDTO>>(allIDs, HttpStatus.OK);
	}

}
