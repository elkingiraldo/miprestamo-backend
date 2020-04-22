package com.miprestamo.apps.miprestamoapi.services.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.miprestamo.apps.miprestamoapi.dtos.BankDTO;
import com.miprestamo.apps.miprestamoapi.entities.Bank;

/**
 * Converter service from DTO to entity and From entity to DTO for banks
 * 
 * @author elkin.giraldo
 *
 */
@Service
public class BankConverterService {

	/**
	 * Method in charge of convert a list of ID entities to a list of ID DTO
	 * 
	 * @param entities, list of entities to convert
	 * @return {@link List<BankDTO>}, the respective DTO for the entities found
	 */
	public List<BankDTO> toDtos(final List<Bank> entities) {

		if (entities.size() == 0) {
			return new ArrayList<BankDTO>();
		}

		final List<BankDTO> dtoList = new ArrayList<BankDTO>();
		for (final Bank Bank : entities) {
			final ModelMapper modelMapper = new ModelMapper();
			dtoList.add(modelMapper.map(Bank, BankDTO.class));
		}

		return dtoList;
	}

}
