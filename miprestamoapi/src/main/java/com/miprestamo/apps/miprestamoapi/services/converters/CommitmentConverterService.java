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
	 * @return {@link List<CommitmentDTO>}
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

	/**
	 * This method transforms {@link Commitment} to {@link CommitmentDTO}
	 * 
	 * @param entity, Commitment entity
	 * @return {@link CommitmentDTO}
	 */
	public CommitmentDTO toDTO(final Commitment entity) {
		final ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(entity, CommitmentDTO.class);
	}

	/**
	 * This method transforms {@link CommitmentDTO} to {@link Commitment}
	 * 
	 * @param dto,       Commitment DTO
	 * @param requestId, unique UUID for tracking request
	 * @return {@link Commitment}
	 */
	public Commitment toEntity(final CommitmentDTO dto, final String requestId) {
		LOGGER.info("[CommitmentConverterService][toEntity][" + requestId + "] Started.");
		final ModelMapper modelMapper = new ModelMapper();
		final Commitment entity = modelMapper.map(dto, Commitment.class);
		LOGGER.info("[CommitmentConverterService][toEntity][" + requestId + "] Finished.");
		return entity;
	}

}
