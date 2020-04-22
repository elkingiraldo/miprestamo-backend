package com.miprestamo.apps.miprestamoapi.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miprestamo.apps.miprestamoapi.dtos.CommitmentDTO;
import com.miprestamo.apps.miprestamoapi.entities.Commitment;
import com.miprestamo.apps.miprestamoapi.exception.APIServiceException;
import com.miprestamo.apps.miprestamoapi.repositories.CommitmentRepository;
import com.miprestamo.apps.miprestamoapi.services.converters.CommitmentConverterService;
import com.miprestamo.apps.miprestamoapi.services.validation.CommitmentValidationService;

/**
 * Service implementation for handling all commitment services
 * 
 * @author elkin.giraldo
 *
 */
@Service
public class CommitmentServiceImpl implements ICommitmentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommitmentServiceImpl.class);

	@Autowired
	private CommitmentRepository commitmentRepository;
	@Autowired
	private CommitmentConverterService commitmentConverterService;
	@Autowired
	private CommitmentValidationService commitmentValidationService;

	@Override
	public List<CommitmentDTO> retrieveCommitmentsByProductAndClient(final String productId, final Integer clientId,
			final String requestId) throws APIServiceException {

		LOGGER.info("[CommitmentServiceImpl][retrieveCommitmentsByProductAndClient][" + requestId + "] Started.");

		commitmentValidationService.validateClientAndProduct(clientId, productId, requestId);

		final List<Commitment> listOfCommitments = commitmentRepository.findByClientIdAndProductId(clientId, productId);
		final List<CommitmentDTO> dtos = commitmentConverterService.toDtos(listOfCommitments, requestId);

		LOGGER.info("[CommitmentServiceImpl][retrieveCommitmentsByProductAndClient][" + requestId + "] Finished.");

		return dtos;
	}

	@Override
	public CommitmentDTO create(final CommitmentDTO commitment, final String requestId) throws APIServiceException {
		LOGGER.info("[CommitmentServiceImpl][create][" + requestId + "] Started.");

		commitmentValidationService.validateCreation(commitment, requestId);
		commitmentValidationService.autocompleteInfo(commitment, requestId);

		final Commitment newCommitment = commitmentRepository
				.save(commitmentConverterService.toEntity(commitment, requestId));
		final CommitmentDTO dto = commitmentConverterService.toDTO(newCommitment);

		LOGGER.info("[CommitmentServiceImpl][create][" + requestId + "] Finished. New commitment created with ID: "
				+ newCommitment.getId() + " for client ID: " + newCommitment.getClientId() + " into the product ID: "
				+ newCommitment.getProductId());
		return dto;
	}

}
