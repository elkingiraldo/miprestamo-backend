package com.miprestamo.apps.miprestamoapi.services.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.miprestamo.apps.miprestamoapi.dtos.ClientDTO;
import com.miprestamo.apps.miprestamoapi.entities.Client;

/**
 * Converter service from DTO to entity and From entity to DTO for clients
 * 
 * @author egiraldo
 *
 */
@Service
public class ClientConverterService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientConverterService.class);

	/**
	 * This method transforms {@link Client} to {@link ClientDTO}
	 * 
	 * @param entity, client entity
	 * @return {@link ClientDTO}
	 */
	public ClientDTO toDTO(final Client entity) {
		final ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(entity, ClientDTO.class);
	}

	/**
	 * This method transforms {@link ClientDTO} to {@link Client}
	 * 
	 * @param dto,      client DTO
	 * @param requestId
	 * @return {@link Client}
	 */
	public Client toEntity(final ClientDTO dto, final String requestId) {
		LOGGER.info("[ClientConverterService][toEntity][" + requestId + "] Started.");
		final ModelMapper modelMapper = new ModelMapper();
		final Client entity = modelMapper.map(dto, Client.class);
		entity.getDocumentDetails().forEach(id -> id.setClient(entity));
		LOGGER.info("[ClientConverterService][toEntity][" + requestId + "] Finished.");
		return entity;
	}

	/**
	 * This method transforms {@link List<Client>} to {@link List<ClientDTO>}
	 * 
	 * @param entities
	 * @param requestId
	 * @return {@link List<ClientDTO>}
	 */
	public List<ClientDTO> toDtos(final List<Client> entities, final String requestId) {
		LOGGER.info("[ClientConverterService][toDtos][" + requestId + "] Started.");
		final List<ClientDTO> dtoList = new ArrayList<ClientDTO>();

		for (final Client client : entities) {
			final ModelMapper modelMapper = new ModelMapper();
			dtoList.add(modelMapper.map(client, ClientDTO.class));
		}
		LOGGER.info("[ClientConverterService][toDtos][" + requestId + "] finished.");
		return dtoList;
	}

}
