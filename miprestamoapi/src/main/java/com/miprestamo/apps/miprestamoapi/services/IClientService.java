package com.miprestamo.apps.miprestamoapi.services;

import java.util.List;

import com.miprestamo.apps.miprestamoapi.dtos.ClientDTO;
import com.miprestamo.apps.miprestamoapi.exception.APIServiceException;

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
	 * @param requestId, unique ID for tracking request
	 * @return {@link List<ClientDTO>}, a list with all clients DTO found in DB.
	 */
	public List<ClientDTO> getAllClients(String requestId);

	/**
	 * This method will call all classes and methods required to build the correct
	 * answer with the client required.
	 * 
	 * @param id, identifier of the client required
	 * @return {@link ClientDTO}, client required.
	 * @throws APIServiceException when client was not found
	 */
	public ClientDTO getClientById(int id) throws APIServiceException;

	/**
	 * This method will call all classes and methods required to create a new client
	 * 
	 * @param client,    client provided to create.
	 * @param requestId, unique ID for tracking request
	 * @return {@link ClientDTO}, client stored in DB
	 * @throws APIServiceException when a validation fails
	 */
	public ClientDTO create(ClientDTO client, String requestId) throws APIServiceException;

}
