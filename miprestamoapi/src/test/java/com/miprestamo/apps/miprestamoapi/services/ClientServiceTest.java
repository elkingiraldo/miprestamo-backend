package com.miprestamo.apps.miprestamoapi.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Locale;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.miprestamo.apps.miprestamoapi.repositories.ClientRepository;

public class ClientServiceTest {

	@InjectMocks
	private ClientServiceImpl clientService;
	@Mock
	private ClientRepository clientRepository;

	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void onlyOneCallToClientRepositoryFindAll() {
		clientService.getAllClients(Locale.ENGLISH.toString());
		verify(clientRepository, times(1)).findAll();
	}

}
