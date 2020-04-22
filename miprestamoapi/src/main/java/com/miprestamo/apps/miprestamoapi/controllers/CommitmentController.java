package com.miprestamo.apps.miprestamoapi.controllers;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miprestamo.apps.miprestamoapi.dtos.CommitmentDTO;
import com.miprestamo.apps.miprestamoapi.exception.APIServiceException;
import com.miprestamo.apps.miprestamoapi.services.CommitmentServiceImpl;

/**
 * Controller to manage client commitments in Mi Prestamo app
 * 
 * @author elkin.giraldo
 *
 */
@RestController
@RequestMapping("/api/v1.0/commitments")
public class CommitmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommitmentController.class);

	@Autowired
	private CommitmentServiceImpl commitmentService;

	/**
	 * This method takes GET API request for handling and passing it to correct
	 * service application layer for searching all current commitments for a
	 * specific client related to a product
	 * 
	 * @param productId, product for searching commitments associated
	 * @param clientId,  client for searching commitments associated
	 * @param locale,    language the client wants to use
	 * @return {@link List<CommitmentDTO>}, a list with all commitments found.
	 * @throws APIServiceException
	 */
	@GetMapping("/{clientId}/{productId}")
	public ResponseEntity<List<CommitmentDTO>> getCommitmentsByProductAndClient(@PathVariable final Integer clientId,
			@PathVariable final String productId,
			@RequestHeader(value = "locale", required = false) final String locale) throws APIServiceException {

		final String requestId = UUID.randomUUID().toString();
		LOGGER.info("[CommitmentController][getCommitmentsByProductAndClient][" + requestId + "] Started.");

		final List<CommitmentDTO> listOfCommitments = commitmentService.retrieveCommitmentsByProductAndClient(productId,
				clientId, requestId);

		LOGGER.info("[CommitmentController][getCommitmentsByProductAndClient][" + requestId + "] Finished.");
		return new ResponseEntity<List<CommitmentDTO>>(listOfCommitments, HttpStatus.OK);
	}

	/**
	 * This method takes POST API request for handling and passing it to correct
	 * service application layer for creating a new commitment for a client in a
	 * specific product.
	 * 
	 * @param commitment, commitment provided in order to create.
	 * @param locale      , language the client wants to use.
	 * @return {@link CommitmentDTO}, commitment saved in DB.
	 * @throws APIServiceException if something was wrong during the process
	 */
	@PostMapping
	public ResponseEntity<CommitmentDTO> create(@RequestBody final CommitmentDTO commitment,
			@RequestHeader(value = "locale", required = false) final String locale) throws APIServiceException {

		final String requestId = UUID.randomUUID().toString();
		LOGGER.info("[CommitmentController][create][" + requestId + "] Started.");

		final CommitmentDTO newCommitment = commitmentService.create(commitment, requestId);

		LOGGER.info("[CommitmentController][create][" + requestId + "] finished.");
		return new ResponseEntity<CommitmentDTO>(newCommitment, HttpStatus.CREATED);
	}

}
