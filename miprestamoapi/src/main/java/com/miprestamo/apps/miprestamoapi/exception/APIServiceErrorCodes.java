package com.miprestamo.apps.miprestamoapi.exception;

import org.springframework.http.HttpStatus;

public enum APIServiceErrorCodes implements IAPIServiceErrorMsg {

	GENERAL_EXCEPTION("general.exception", HttpStatus.INTERNAL_SERVER_ERROR),
	GENERAL_DTO_CANT_BE_NULL_EXCEPTION("general.dto.cant.be.null.exception", HttpStatus.BAD_REQUEST),
	GENERAL_ATTRIBUTE_REQUIRED_EXCEPTION("general.attribute.required.exception", HttpStatus.BAD_REQUEST),
	GENERAL_SET_SIZE_CANT_BE_ZERO_EXCEPTION("general.set.size.cant.be.zero.exception", HttpStatus.BAD_REQUEST),

	CLIENT_NOT_FOUND_EXCEPTION("api.client.not.found.exception", HttpStatus.BAD_REQUEST),
	CLIENT_INVALID_IDENTIFICATION_DOCUMENT_ID_EXCEPTION("api.client.invalid.identification.document.id.exception",
			HttpStatus.BAD_REQUEST),

	PRODUCT_NOT_FOUND_EXCEPTION("api.product.not.found.exception", HttpStatus.BAD_REQUEST);

	private String message;
	private HttpStatus httpStatus;
	private String errorDetail;

	private APIServiceErrorCodes(final String message, final HttpStatus httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}

	private APIServiceErrorCodes(final String message, final String errorDetail, final HttpStatus httpStatus) {
		this.message = message;
		this.errorDetail = errorDetail;
		this.httpStatus = httpStatus;
	}

	private APIServiceErrorCodes(final String message) {
		this.message = message;
	}

	public String getErrorDetail() {
		return errorDetail;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
