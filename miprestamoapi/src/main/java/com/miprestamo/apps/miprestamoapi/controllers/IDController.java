package com.miprestamo.apps.miprestamoapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miprestamo.apps.miprestamoapi.dtos.IdentificationDocumentDTO;
import com.miprestamo.apps.miprestamoapi.services.IDServiceImpl;

@RestController
@RequestMapping("/api/v1.0/ids")
public class IDController {

	@Autowired
	private IDServiceImpl idService;

	@GetMapping
	public ResponseEntity<List<IdentificationDocumentDTO>> getDocumentsType() {
		final List<IdentificationDocumentDTO> allIDs = idService.retrieveAllDocumentsType();
		return new ResponseEntity<List<IdentificationDocumentDTO>>(allIDs, HttpStatus.OK);
	}

}
