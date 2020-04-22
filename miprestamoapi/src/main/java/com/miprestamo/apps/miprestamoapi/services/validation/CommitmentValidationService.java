package com.miprestamo.apps.miprestamoapi.services.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miprestamo.apps.miprestamoapi.dtos.CommitmentDTO;
import com.miprestamo.apps.miprestamoapi.emuns.CommitmentStatus;
import com.miprestamo.apps.miprestamoapi.exception.APIServiceErrorCodes;
import com.miprestamo.apps.miprestamoapi.exception.APIServiceException;

/**
 * This class will handle all validations that commitment needs
 * 
 * @author elkin.giraldo
 *
 */
@Service
public class CommitmentValidationService extends GeneralValidation {

	private static final String PRODUCT_ID = "productId";
	private static final String CLIENT_ID = "clientId";
	private static final String NAME = "name";
	private static final String DECRIPTION = "decription";
	private static final String INITIAL_DEBT = "initialDebt";
	private static final String PERIODS = "periods";
	private static final Integer MINIMUM_NUMBER_OF_PERIODS = 1;
	private static final Long MINIMUM_INITIAL_DEBT = 1L;
	private static final int INITIAL_PERIOD = 1;

	@Autowired
	private ClientValidationService clientValidationService;
	@Autowired
	private ProductValidationService productValidationService;

	private static final Logger LOGGER = LoggerFactory.getLogger(CommitmentValidationService.class);

	/**
	 * This method validate if the client ID and product ID provided are already
	 * stored in the DB
	 * 
	 * @param clientId,  client ID provided
	 * @param productId, product ID provided
	 * @param requestId, unique ID for tracking request
	 * @throws APIServiceException if client ID or product ID don't exist in DB
	 */
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

	/**
	 * This method verifies all the constraints for creating a new commitment
	 * 
	 * @param commitment, DTO to verify.
	 * @param requestId,  unique UUID for tracking request.
	 * @throws APIServiceException if any validation fails.
	 */
	public void validateCreation(final CommitmentDTO commitment, final String requestId) throws APIServiceException {
		LOGGER.info("[CommitmentValidationService][validateCreation][" + requestId + "] Started.");
		validateObjectNotNull(commitment, CommitmentDTO.class.toString());
		validateAttributeNotNull(commitment.getClientId(), CLIENT_ID);
		validateAttributeNotNull(commitment.getProductId(), PRODUCT_ID);
		validateAttributeNotNull(commitment.getName(), NAME);
		validateAttributeNotNull(commitment.getDescription(), DECRIPTION);
		validateAttributeNotNull(commitment.getInitialDebt(), INITIAL_DEBT);
		validateAttributeNotNull(commitment.getPeriods(), PERIODS);
		validateMinimumNumberOfPeriods(commitment.getPeriods());
		validateMinumunInitialDebt(commitment.getInitialDebt());
		validateClientAndProduct(commitment.getClientId(), commitment.getProductId(), requestId);
		LOGGER.info("[CommitmentValidationService][validateCreation][" + requestId + "] Finished.");
	}

	/**
	 * This method auto-complete the information required.
	 * 
	 * @param commitment, provided for auto-completing it
	 * @param requestId,  unique UUD for tracking the request
	 */
	public void autocompleteInfo(final CommitmentDTO commitment, final String requestId) {
		commitment.setCurrentDebt(commitment.getInitialDebt());
		commitment.setCurrentPeriod(INITIAL_PERIOD);
		commitment.setDisabled(false);
		commitment.setStatus(CommitmentStatus.PENDING);
		// TODO change types from integer to double
		commitment.setPeriodDebt(commitment.getInitialDebt() / commitment.getPeriods());
	}

	/**
	 * Validate minimum number of periods
	 * 
	 * @param periods, value to check
	 * @throws APIServiceException if the period doesn't meet minimum
	 */
	private void validateMinimumNumberOfPeriods(final Integer periods) throws APIServiceException {
		if (periods < MINIMUM_NUMBER_OF_PERIODS) {
			throw new APIServiceException(APIServiceErrorCodes.COMMITMENT_MINIMUM_NUMBER_OF_PERIODS_EXCEPTION);
		}
	}

	/**
	 * Validate minimum value of initial debt
	 * 
	 * @param initialDebt, value to check
	 * @throws APIServiceException if the initial debt doesn't meet minimum
	 */
	private void validateMinumunInitialDebt(final Long initialDebt) throws APIServiceException {
		if (initialDebt < MINIMUM_INITIAL_DEBT) {
			throw new APIServiceException(APIServiceErrorCodes.COMMITMENT_MINIMUM_INITIAL_DEBT_EXCEPTION);
		}
	}

}
