package com.miprestamo.apps.miprestamoapi.services.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.miprestamo.apps.miprestamoapi.dtos.ProductDTO;
import com.miprestamo.apps.miprestamoapi.entities.Product;

/**
 * Converter service from DTO to entity and From entity to DTO for Products
 * 
 * @author elkin.giraldo
 *
 */
@Service
public class ProductConverterService {

	/**
	 * Method in charge of convert a list of ID entities to a list of ID DTO
	 * 
	 * @param entities, list of entities to convert
	 * @return {@link List<ProductDTO>}, the respective DTO for the entities found
	 */
	public List<ProductDTO> toDtos(final List<Product> entities) {

		if (entities.size() == 0) {
			return new ArrayList<ProductDTO>();
		}

		final List<ProductDTO> dtoList = new ArrayList<ProductDTO>();
		for (final Product Product : entities) {
			final ModelMapper modelMapper = new ModelMapper();
			dtoList.add(modelMapper.map(Product, ProductDTO.class));
		}

		return dtoList;
	}

}
