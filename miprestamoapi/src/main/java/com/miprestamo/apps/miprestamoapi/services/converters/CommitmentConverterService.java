package com.miprestamo.apps.miprestamoapi.services.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.miprestamo.apps.miprestamoapi.dtos.CommitmentDTO;
import com.miprestamo.apps.miprestamoapi.entities.Commitment;

/**
 * Converter service from DTO to entity and From entity to DTO for commitments
 * 
 * @author elkin.giraldo
 *
 */
@Service
public class CommitmentConverterService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommitmentConverterService.class);

	/**
	 * This method transforms {@link List<Commitment>} to
	 * {@link List<CommitmentDTO>}
	 * 
	 * @param entities
	 * @param requestId
	 * @return {@link List<ClientDTO>}
	 */
	public List<CommitmentDTO> toDtos(final List<Commitment> entities, final String requestId) {
		LOGGER.info("[CommitmentsConverterService][toDtos][" + requestId + "] Started. Number of entities found: "
				+ entities.size());
		final List<CommitmentDTO> dtoList = new ArrayList<CommitmentDTO>();

		for (final Commitment Commitment : entities) {
			final ModelMapper modelMapper = new ModelMapper();
			dtoList.add(modelMapper.map(Commitment, CommitmentDTO.class));
		}
		LOGGER.info("[CommitmentsConverterService][toDtos][" + requestId + "] finished.");
		return dtoList;
	}

}
