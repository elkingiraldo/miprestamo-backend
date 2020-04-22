package com.miprestamo.apps.miprestamoapi.services.validation;

import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.miprestamo.apps.miprestamoapi.exception.APIServiceErrorCodes;
import com.miprestamo.apps.miprestamoapi.exception.APIServiceException;

/**
 * General validations for the API
 * 
 * @author egiraldo
 *
 */
@Service
public class GeneralValidation {

	private static final Function<String, String> DTO_NAME = name -> "DTO: " + name;

	/**
	 * Validate if an object is null or not
	 * 
	 * @param obj
	 * @param className
	 * @throws APIServiceException
	 */
	protected void validateObjectNotNull(final Object obj, final String className) throws APIServiceException {
		if (Objects.isNull(obj)) {
			throw new APIServiceException(DTO_NAME.apply(className),
					APIServiceErrorCodes.GENERAL_DTO_CANT_BE_NULL_EXCEPTION);
		}
	}

	/**
	 * Validate if an attribute is null or not
	 * 
	 * @param atribute,      Object to validate if it's null
	 * @param attributeName, String with the name of the attribute
	 * @throws APIServiceException
	 */
	protected void validateAttributeNotNull(final Object atribute, final String attributeName)
			throws APIServiceException {
		if (Objects.isNull(atribute)) {
			throw new APIServiceException(attributeName, APIServiceErrorCodes.GENERAL_ATTRIBUTE_REQUIRED_EXCEPTION);
		}
	}

	/**
	 * Validate if an object is present into the attributes
	 * 
	 * @param obj
	 * @param attributeName
	 * @throws APIServiceException
	 */
	protected void valitadeObjectIsPresentInAttributes(final Object obj, final String attributeName)
			throws APIServiceException {
		if (Objects.isNull(obj)) {
			throw new APIServiceException(DTO_NAME.apply(attributeName),
					APIServiceErrorCodes.GENERAL_ATTRIBUTE_REQUIRED_EXCEPTION);
		}
	}

	/**
	 * Validate if a Set has at least one element
	 * 
	 * @param <T>
	 * @param set
	 * @param attributeName
	 * @throws APIServiceException
	 */
	protected <T> void validateSizeOfSet(final Set<T> set, final String attributeName) throws APIServiceException {
		if (set.size() == 0) {
			throw new APIServiceException(attributeName, APIServiceErrorCodes.GENERAL_SET_SIZE_CANT_BE_ZERO_EXCEPTION);
		}
	}

}
