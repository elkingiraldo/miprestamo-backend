package com.miprestamo.apps.miprestamoapi.services.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.miprestamo.apps.miprestamoapi.dtos.IdentificationDocumentDTO;
import com.miprestamo.apps.miprestamoapi.entities.IdentificationDocument;

/**
 * Converter service from DTO to entity and From entity to DTO for
 * IdentificationDocuments
 * 
 * @author egiraldo
 *
 */
@Service
public class IDConverterService {

	/**
	 * Method in charge of convert a list of ID entities to a list of ID DTO
	 * 
	 * @param entities, list of entities to convert
	 * @return {@link List<IdentificationDocumentDTO>}, the respective DTO for the
	 *         entities found
	 */
	public List<IdentificationDocumentDTO> toDtos(final List<IdentificationDocument> entities) {

		if (entities.size() == 0) {
			return new ArrayList<IdentificationDocumentDTO>();
		}

		final List<IdentificationDocumentDTO> dtoList = new ArrayList<IdentificationDocumentDTO>();
		for (final IdentificationDocument IdentificationDocument : entities) {
			final ModelMapper modelMapper = new ModelMapper();
			dtoList.add(modelMapper.map(IdentificationDocument, IdentificationDocumentDTO.class));
		}

		return dtoList;
	}

}
