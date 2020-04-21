package com.miprestamo.apps.miprestamoapi.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miprestamo.apps.miprestamoapi.entities.Commitment;

/**
 * JPA repository for {@link Commitment} entities
 * 
 * @author elkin.giraldo
 *
 */
public interface CommitmentRepository extends JpaRepository<Commitment, UUID> {

	public List<Commitment> findByClientIdAndProductId(Integer clientId, String productId);

}
