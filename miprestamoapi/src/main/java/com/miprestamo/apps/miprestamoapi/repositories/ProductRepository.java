package com.miprestamo.apps.miprestamoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miprestamo.apps.miprestamoapi.entities.Product;

/**
 * JPA repository for {@link Product} entities
 * 
 * @author elkin.giraldo
 *
 */
public interface ProductRepository extends JpaRepository<Product, String> {

}
