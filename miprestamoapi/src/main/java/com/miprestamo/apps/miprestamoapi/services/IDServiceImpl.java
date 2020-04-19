package com.miprestamo.apps.miprestamoapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miprestamo.apps.miprestamoapi.dtos.IdentificationDocumentDTO;
import com.miprestamo.apps.miprestamoapi.entities.IdentificationDocument;
import com.miprestamo.apps.miprestamoapi.repositories.IDRepository;
import com.miprestamo.apps.miprestamoapi.services.converters.IDConverterService;

/**
 * Service implementation for handling all ID services
 * 
 * @author egiraldo
 *
 */
@Service
public class IDServiceImpl implements IIDService {

	@Autowired
	private IDRepository idRepository;
	@Autowired
	private IDConverterService idConverterService;

	@Override
	public List<IdentificationDocumentDTO> retrieveAllDocumentsType() {
		final List<IdentificationDocument> allIDs = idRepository.findAll();
		return idConverterService.toDtos(allIDs);
	}

}
