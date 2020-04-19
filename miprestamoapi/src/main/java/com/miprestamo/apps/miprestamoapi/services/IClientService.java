package com.miprestamo.apps.miprestamoapi.services;

import java.util.List;

import com.miprestamo.apps.miprestamoapi.dtos.ClientDTO;

/**
 * Interface in charge of handling all client requests
 * 
 * @author egiraldo
 *
 */
public interface IClientService {

	/**
	 * This method will call all classes and methods required to build the correct
	 * answer with the list of all current clients.
	 * 
	 * @return {@link List<ClientDTO>}, a list with all clients DTO found in DB.
	 */
	public List<ClientDTO> getAllClients();

	/**
	 * This method will call all classes and methods required to build the correct
	 * answer with the client required.
	 * 
	 * @param id, identifier of the client required
	 * @return {@link ClientDTO}, client required.
	 */
	public ClientDTO getClientById(int id);

	/**
	 * This method will call all classes and methods required to create a new client
	 * 
	 * @param client, client provided to create.
	 * @return {@link ClientDTO}, cleint stored in DB
	 */
	public ClientDTO create(ClientDTO client);

}
