package com.miprestamo.apps.miprestamoapi.services.validation;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miprestamo.apps.miprestamoapi.dtos.ClientDTO;
import com.miprestamo.apps.miprestamoapi.dtos.DocumentDetailsDTO;
import com.miprestamo.apps.miprestamoapi.dtos.IdentificationDocumentDTO;
import com.miprestamo.apps.miprestamoapi.exception.APIServiceErrorCodes;
import com.miprestamo.apps.miprestamoapi.exception.APIServiceException;
import com.miprestamo.apps.miprestamoapi.services.IDServiceImpl;

/**
 * This class will handle all validations that client need
 * 
 * @author egiraldo
 *
 */
@Service
public class ClientValidationService extends GeneralValidation {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientValidationService.class);

	@Autowired
	private IDServiceImpl idService;

	private static final String FIRST_NAME = "firstName";
	private static final String FIRST_LAST_NAME = "firstLastName";
	private static final String DOCUMENT_DETAILS = "documentDetails";
	private static final String IDENTIFICATION_DOCUMENT_ID = "identificationDocumentId";
	private static final String DOCUMENT_NUMBER = "documentNumber";

	/**
	 * This method verifies all the constraints for create a new client
	 * 
	 * @param requestId,UUID for tracking request
	 * 
	 * @param client,        is the DTO sent for the client
	 * @throws APIServiceException when any validation fails
	 */
	public void validateCreation(final ClientDTO client, final String requestId) throws APIServiceException {
		LOGGER.info("[ClientValidationService][validateCreation][" + requestId + "] Started.");
		validateObjectNotNull(client, ClientDTO.class.toString());
		validateAttributeNotNull(client.getFirstName(), FIRST_NAME);
		validateAttributeNotNull(client.getFirstLastName(), FIRST_LAST_NAME);
		valitadeObjectIsPresentInAttributes(client.getDocumentDetails(), DOCUMENT_DETAILS);
		validateSizeOfSet(client.getDocumentDetails(), DOCUMENT_DETAILS);
		validateDocumentDetails(client.getDocumentDetails());
		LOGGER.info("[ClientValidationService][validateCreation][" + requestId + "] finished.");
	}

	/**
	 * Validate ID details for a new client
	 * 
	 * @param documentDetails, is a Set of {@link DocumentDetailsDTO}
	 * @throws APIServiceException if there are something wrong with the ID
	 */
	private void validateDocumentDetails(final Set<DocumentDetailsDTO> documentDetails) throws APIServiceException {
		for (final DocumentDetailsDTO documentDetail : documentDetails) {
			validateAttributeNotNull(documentDetail.getIdentificationDocumentId(), IDENTIFICATION_DOCUMENT_ID);
			validateAttributeNotNull(documentDetail.getDocumentNumber(), DOCUMENT_NUMBER);
			validateIdentificationDocumentId(documentDetail);
		}
	}

	/**
	 * Validate if the identificationDocumentId is valid or not
	 * 
	 * @param documentDetailDto
	 * @throws APIServiceException if the ID not found in DB
	 */
	private void validateIdentificationDocumentId(final DocumentDetailsDTO documentDetailDto)
			throws APIServiceException {
		final List<IdentificationDocumentDTO> retrieveAllDocumentsType = idService.retrieveAllDocumentsType();
		boolean isValidId = false;
		for (final IdentificationDocumentDTO idDTO : retrieveAllDocumentsType) {
			if (idDTO.getId().equals(documentDetailDto.getIdentificationDocumentId())) {
				isValidId = true;
			}
		}
		if (!isValidId) {
			throw new APIServiceException(documentDetailDto.getDocumentNumber(),
					APIServiceErrorCodes.CLIENT_INVALID_IDENTIFICATION_DOCUMENT_ID_EXCEPTION);
		}
	}

}