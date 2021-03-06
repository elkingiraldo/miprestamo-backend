package com.miprestamo.apps.miprestamoapi.services;

import java.util.List;

import com.miprestamo.apps.miprestamoapi.dtos.CommitmentDTO;
import com.miprestamo.apps.miprestamoapi.exception.APIServiceException;

/**
 * Interface in charge of handling all commitment requests
 * 
 * @author elkin.giraldo
 *
 */
public interface ICommitmentService {

	/**
	 * This method will call all classes and methods required to build the correct
	 * answer with the list of all current commitments related to the product and
	 * client sent by user.
	 * 
	 * @param productId, product for searching commitments associated
	 * @param clientId,  client for searching commitments associate
	 * @param requestId, unique ID for tracking request
	 * @return {@link List<CommitmentDTO>}, a list with all commitment DTO found in
	 *         DB.
	 * @throws APIServiceException when client or product not found in DB
	 */
	public List<CommitmentDTO> retrieveCommitmentsByProductAndClient(String productId, Integer clientId,
			String requestId) throws APIServiceException;

	/**
	 * This method will call all classes and methods required for validating the
	 * input DTO and creating a new commitment for a client related to an specific
	 * product
	 * 
	 * @param commitment, commitment provided to create.
	 * @param requestId,  unique UUID for tracking request
	 * @return {@link CommitmentDTO}
	 * @throws APIServiceException if any validation fails
	 */
	public CommitmentDTO create(CommitmentDTO commitment, String requestId) throws APIServiceException;

}
