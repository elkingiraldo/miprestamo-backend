package com.miprestamo.apps.miprestamoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miprestamo.apps.miprestamoapi.entities.IdentificationDocument;

public interface IDRepository extends JpaRepository<IdentificationDocument, String> {

}
