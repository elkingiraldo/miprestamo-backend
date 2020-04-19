package com.miprestamo.apps.miprestamoapi.services.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
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

	public ClientDTO toDTO(final Client entity) {
		final ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(entity, ClientDTO.class);
	}

	public Client toEntity(final ClientDTO dto) {
		final ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, Client.class);
	}

	public List<ClientDTO> toDtos(final List<Client> entities) {
		final List<ClientDTO> dtoList = new ArrayList<ClientDTO>();

		for (final Client client : entities) {
			final ModelMapper modelMapper = new ModelMapper();
			dtoList.add(modelMapper.map(client, ClientDTO.class));
		}

		return dtoList;
	}

}
