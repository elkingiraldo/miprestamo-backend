package com.miprestamo.apps.miprestamoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miprestamo.apps.miprestamoapi.entities.Bank;

/**
 * JPA repository for {@link Bank} entities
 * 
 * @author elkin.giraldo
 *
 */
public interface BankRepository extends JpaRepository<Bank, String> {

}
