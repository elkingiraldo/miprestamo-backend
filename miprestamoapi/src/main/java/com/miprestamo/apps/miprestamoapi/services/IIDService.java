package com.miprestamo.apps.miprestamoapi.services;

import java.util.List;

import com.miprestamo.apps.miprestamoapi.dtos.IdentificationDocumentDTO;

public interface IIDService {

	public List<IdentificationDocumentDTO> retrieveAllDocumentsType();

}
