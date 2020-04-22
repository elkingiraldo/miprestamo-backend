package com.miprestamo.apps.miprestamoapi.services;

import java.util.List;

import com.miprestamo.apps.miprestamoapi.dtos.ProductDTO;

/**
 * Interface for handling services related to Products
 * 
 * @author elkin.giraldo
 *
 */
public interface IProductService {

	/**
	 * This method will call all classes and methods required to build the correct
	 * answer with the list of Products DTO
	 * 
	 * @return {@link List<ProductDTO>} a list with the Products found in DB
	 */
	public List<ProductDTO> retrieveAllProducts();

}
