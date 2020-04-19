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

	public List<IdentificationDocumentDTO> toDtos(final List<IdentificationDocument> entities) {
		final List<IdentificationDocumentDTO> dtoList = new ArrayList<IdentificationDocumentDTO>();

		for (final IdentificationDocument IdentificationDocument : entities) {
			final ModelMapper modelMapper = new ModelMapper();
			dtoList.add(modelMapper.map(IdentificationDocument, IdentificationDocumentDTO.class));
		}

		return dtoList;
	}

}
