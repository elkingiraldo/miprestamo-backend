package com.miprestamo.apps.miprestamoapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.miprestamo.apps.miprestamoapi.dtos.ClientDTO;
import com.miprestamo.apps.miprestamoapi.entities.Client;
import com.miprestamo.apps.miprestamoapi.entities.DocumentDetails;
import com.miprestamo.apps.miprestamoapi.entities.IdentificationDocument;
import com.miprestamo.apps.miprestamoapi.exception.APIServiceException;
import com.miprestamo.apps.miprestamoapi.repositories.ClientRepository;
import com.miprestamo.apps.miprestamoapi.services.converters.ClientConverterService;
import com.miprestamo.apps.miprestamoapi.services.validation.ClientValidationService;

public class ClientServiceTest {

	@InjectMocks
	private ClientServiceImpl clientService;
	@Mock
	private ClientRepository clientRepository;
	@Mock
	private ClientConverterService clientConverterService;
	@Mock
	private ClientValidationService clientValidationService;

	private final List<Client> clientList = new ArrayList<>();
	private final Client client01 = new Client();
	private final Client client02 = new Client();

	private final Set<DocumentDetails> set01 = new HashSet<>();
	private final DocumentDetails documentDetails01 = new DocumentDetails();

	private final IdentificationDocument identificationDocumentId = new IdentificationDocument();

	private final List<ClientDTO> clientListDto = new ArrayList<>();
	private final ClientDTO clientDTO01 = new ClientDTO();
	private final ClientDTO clientDTO02 = new ClientDTO();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		client01.setId(1);
		client01.setFirstName("name");
		client01.setFirstLastName("last name");

		identificationDocumentId.setId("TD-001");
		documentDetails01.setIdentificationDocumentId(identificationDocumentId);
		documentDetails01.setDocumentNumber("1111");

		set01.add(documentDetails01);
		client01.setDocumentDetails(set01);

		clientList.add(client01);
		clientList.add(client02);

		clientListDto.add(clientDTO01);
		clientListDto.add(clientDTO02);
	}

	@Test
	public void onlyOneCallToClientRepositoryAndClientConverterOnGetAllClients() {
		clientService.getAllClients(Locale.ENGLISH.toString());
		verify(clientRepository, times(1)).findAll();
		verify(clientConverterService, times(1)).toDtos(any(), anyString());
	}

	@Test
	public void shouldReturnAllClients() {
		when(clientRepository.findAll()).thenReturn(clientList);
		when(clientConverterService.toDtos(any(), anyString())).thenReturn(clientListDto);
		final List<ClientDTO> result = clientService.getAllClients(Locale.ENGLISH.toString());
		assertEquals(clientListDto, result);
	}

	@Test
	public void shouldFindClientById() throws APIServiceException {
		when(clientRepository.findById(1)).thenReturn(Optional.of(client01));
		when(clientConverterService.toDTO(client01)).thenReturn(clientDTO01);
		final ClientDTO result = clientService.getClientById(1);
		assertEquals(clientDTO01, result);
	}

	@Test(expected = APIServiceException.class)
	public void shouldThrowAPIServiceExceptionWhenClientByIdNotFound() throws APIServiceException {
		when(clientRepository.findById(1)).thenReturn(Optional.empty());
		clientService.getClientById(1);
	}

	@Test
	public void shouldCreateClientSuccessfully() throws APIServiceException {
		when(clientRepository.save(client01)).thenReturn(client01);
		when(clientConverterService.toEntity(any(), anyString())).thenReturn(client01);
		when(clientConverterService.toDTO(client01)).thenReturn(clientDTO01);
		doNothing().when(clientValidationService).validateCreation(any(), anyString());
		doNothing().when(clientValidationService).autocompleteInfo(any(), anyString());
		final ClientDTO createdClient = clientService.create(any(), anyString());
		assertEquals(clientDTO01, createdClient);
	}

}
