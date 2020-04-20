package com.miprestamo.apps.miprestamoapi.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.miprestamo.apps.miprestamoapi.dtos.IdentificationDocumentDTO;
import com.miprestamo.apps.miprestamoapi.services.IDServiceImpl;

public class IDControllerTest {

	@InjectMocks
	private IDController idController;
	@Mock
	private IDServiceImpl idService;

	private final List<IdentificationDocumentDTO> dtoList = new ArrayList<>();
	private final IdentificationDocumentDTO idDto = new IdentificationDocumentDTO();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		dtoList.add(idDto);
	}

	@Test
	public void onlyOneCallToIdServiceRetrieveAllDocuments() {
		idController.getDocumentsType(Locale.ENGLISH.toString());
		verify(idService, times(1)).retrieveAllDocumentsType();
	}

	@Test
	public void dtoListNotAffectedInGetAllClientsMethod() {
		when(idService.retrieveAllDocumentsType()).thenReturn(dtoList);
		final ResponseEntity<List<IdentificationDocumentDTO>> allDOcuments = idController
				.getDocumentsType(Locale.ENGLISH.toString());
		assertEquals(dtoList.size(), allDOcuments.getBody().size());
		assertEquals(dtoList, allDOcuments.getBody());
	}

}
