package com.miprestamo.apps.miprestamoapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miprestamo.apps.miprestamoapi.dtos.ProductDTO;
import com.miprestamo.apps.miprestamoapi.entities.Product;
import com.miprestamo.apps.miprestamoapi.repositories.ProductRepository;
import com.miprestamo.apps.miprestamoapi.services.converters.ProductConverterService;

/**
 * Service implementation for handling all Product services
 * 
 * @author elkin.giraldo
 *
 */
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductConverterService productConverterService;

	@Override
	public List<ProductDTO> retrieveAllProducts() {
		final List<Product> allIDs = productRepository.findAll();
		return productConverterService.toDtos(allIDs);
	}

}
