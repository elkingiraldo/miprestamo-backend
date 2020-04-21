package com.miprestamo.apps.miprestamoapi.services.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miprestamo.apps.miprestamoapi.repositories.ProductRepository;

/**
 * This class will handle all validations that product needs
 * 
 * @author elkin.giraldo
 *
 */
@Service
public class ProductValidationService {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * This method will validate if product exists or not in DB
	 * 
	 * @param clientId
	 * @return a boolean with the result of operation
	 */
	public boolean validateIfProductExists(final String productId) {
		return productRepository.existsById(productId);
	}

}
