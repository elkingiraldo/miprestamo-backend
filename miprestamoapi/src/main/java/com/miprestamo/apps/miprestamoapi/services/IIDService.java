package com.miprestamo.apps.miprestamoapi.services;

import java.util.List;

import com.miprestamo.apps.miprestamoapi.dtos.IdentificationDocumentDTO;

/**
 * Interface for handling services related to IDs
 * 
 * @author egiraldo
 *
 */
public interface IIDService {

	/**
	 * This method will call all classes and methods required to build the correct
	 * answer with the list of IDs DTO
	 * 
	 * @return {@link List<IdentificationDocumentDTO>} a list with the IDs found in
	 *         DB
	 */
	public List<IdentificationDocumentDTO> retrieveAllDocumentsType();

}
