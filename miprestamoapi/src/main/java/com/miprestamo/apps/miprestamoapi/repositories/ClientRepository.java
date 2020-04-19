package com.miprestamo.apps.miprestamoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miprestamo.apps.miprestamoapi.entities.Client;

/**
 * JPA repository for {@link Client} entities
 * 
 * @author egiraldo
 *
 */
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
