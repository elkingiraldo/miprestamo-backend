package com.miprestamo.apps.miprestamoapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.miprestamo.apps.miprestamoapi.dtos.IdentificationDocumentDTO;
import com.miprestamo.apps.miprestamoapi.entities.IdentificationDocument;
import com.miprestamo.apps.miprestamoapi.repositories.IDRepository;
import com.miprestamo.apps.miprestamoapi.services.converters.IDConverterService;

public class IDServiceTest {

	@InjectMocks
	private IDServiceImpl idService;
	@Mock
	private IDRepository idRepository;
	@Mock
	private IDConverterService idConverterService;

	private final List<IdentificationDocument> entityList = new ArrayList<>();
	private final IdentificationDocument idEntity = new IdentificationDocument();

	private final List<IdentificationDocumentDTO> dtoList = new ArrayList<>();
	private final IdentificationDocumentDTO idDto = new IdentificationDocumentDTO();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		entityList.add(idEntity);
		dtoList.add(idDto);
	}

	@Test
	public void onlyOneCallToIdRepository() {
		idService.retrieveAllDocumentsType();
		verify(idRepository, times(1)).findAll();
	}

	@Test
	public void dtoListNotAffectedInRetrieveAllClientsMethod() {
		when(idRepository.findAll()).thenReturn(entityList);
		when(idConverterService.toDtos(entityList)).thenReturn(dtoList);
		final List<IdentificationDocumentDTO> allDocuments = idService.retrieveAllDocumentsType();
		assertEquals(dtoList.size(), allDocuments.size());
		assertEquals(dtoList, allDocuments);
	}

}
