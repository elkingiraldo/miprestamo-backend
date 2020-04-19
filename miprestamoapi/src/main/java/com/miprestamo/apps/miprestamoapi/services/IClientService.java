package com.miprestamo.apps.miprestamoapi.services;

import java.util.List;

import com.miprestamo.apps.miprestamoapi.dtos.ClientDTO;

public interface IClientService {

	public List<ClientDTO> getAllClients();

	public ClientDTO getClientById(String id);

}
