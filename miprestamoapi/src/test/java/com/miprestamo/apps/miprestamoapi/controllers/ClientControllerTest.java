package com.miprestamo.apps.miprestamoapi.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.miprestamo.apps.miprestamoapi.dtos.ClientDTO;
import com.miprestamo.apps.miprestamoapi.dtos.DocumentDetailsDTO;
import com.miprestamo.apps.miprestamoapi.exception.APIServiceException;
import com.miprestamo.apps.miprestamoapi.services.ClientServiceImpl;

public class ClientControllerTest {

	@InjectMocks
	private ClientController clientController;
	@Mock
	private ClientServiceImpl clientService;

	private final List<ClientDTO> dtoList = new ArrayList<>();

	private final ClientDTO client01 = new ClientDTO();
	private final ClientDTO client02 = new ClientDTO();

	private final DocumentDetailsDTO documentDetails01 = new DocumentDetailsDTO();
	private final DocumentDetailsDTO documentDetails02 = new DocumentDetailsDTO();
	private final DocumentDetailsDTO documentDetails03 = new DocumentDetailsDTO();

	private final Set<DocumentDetailsDTO> set01 = new HashSet<>();
	private final Set<DocumentDetailsDTO> set02 = new HashSet<>();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		client01.setFirstName("name");
		client01.setFirstLastName("last name");
		documentDetails01.setDocumentNumber("1111");
		documentDetails01.setIdentificationDocumentId("TD-001");
		set01.add(documentDetails01);
		client01.setDocumentDetails(set01);

		client02.setFirstName("name2");
		client02.setFirstLastName("last name2");
		documentDetails02.setDocumentNumber("2222");
		documentDetails02.setIdentificationDocumentId("TD-003");
		documentDetails03.setDocumentNumber("3333");
		documentDetails03.setIdentificationDocumentId("TD-002");
		set02.add(documentDetails02);
		set02.add(documentDetails03);
		client02.setDocumentDetails(set01);

		dtoList.add(client01);
		dtoList.add(client02);
	}

	@Test
	public void onlyOneCallToClientServiceGetAllCLients() {
		clientController.getAllClients(Locale.ENGLISH.toString());
		verify(clientService, times(1)).getAllClients(anyString());
	}

	@Test
	public void dtoListNotAffectedInGetAllClientsMethod() {
		when(clientService.getAllClients(anyString())).thenReturn(dtoList);
		final ResponseEntity<List<ClientDTO>> allClients = clientController.getAllClients(Locale.ENGLISH.toString());
		assertEquals(dtoList.size(), allClients.getBody().size());
		assertEquals(dtoList, allClients.getBody());
	}

	@Test
	public void onlyOneCallToClientServicePost() throws APIServiceException {
		clientController.post(client01, Locale.ENGLISH.toString());
		verify(clientService, times(1)).create(any(), anyString());
	}

	@Test
	public void dtoNotAffectedInCreateMethod() throws APIServiceException {
		when(clientService.create(any(), anyString())).thenReturn(client02);
		final ResponseEntity<ClientDTO> response = clientController.post(client02, Locale.ENGLISH.toString());
		assertEquals(client02, response.getBody());
	}

}
