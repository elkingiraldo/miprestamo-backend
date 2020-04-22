package com.miprestamo.apps.miprestamoapi.services.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miprestamo.apps.miprestamoapi.exception.APIServiceErrorCodes;
import com.miprestamo.apps.miprestamoapi.exception.APIServiceException;

/**
 * This class will handle all validations that commitment needs
 * 
 * @author elkin.giraldo
 *
 */
@Service
public class CommitmentValidationService {

	@Autowired
	private ClientValidationService clientValidationService;
	@Autowired
	private ProductValidationService productValidationService;

	private static final Logger LOGGER = LoggerFactory.getLogger(CommitmentValidationService.class);

	public void validateClientAndProduct(final Integer clientId, final String productId, final String requestId)
			throws APIServiceException {
		LOGGER.info("[CommitmentValidationService][validateClientAndProduct][" + requestId + "] Started.");

		if (!clientValidationService.validateIfClientExists(clientId)) {
			throw new APIServiceException(clientId.toString(), APIServiceErrorCodes.CLIENT_NOT_FOUND_EXCEPTION);
		}
		if (!productValidationService.validateIfProductExists(productId)) {
			throw new APIServiceException(productId.toString(), APIServiceErrorCodes.PRODUCT_NOT_FOUND_EXCEPTION);
		}

		LOGGER.info("[CommitmentValidationService][validateClientAndProduct][" + requestId + "] Finished.");
	}

}
