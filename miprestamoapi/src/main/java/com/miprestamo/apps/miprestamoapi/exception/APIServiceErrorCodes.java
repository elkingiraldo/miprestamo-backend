package com.miprestamo.apps.miprestamoapi.exception;

import org.springframework.http.HttpStatus;

public enum APIServiceErrorCodes implements IAPIServiceErrorMsg {

	GENERAL_EXCEPTION("general.exception", HttpStatus.INTERNAL_SERVER_ERROR),
	CRITERIA_NOT_FOUND("criteria.not.found.exception", HttpStatus.BAD_REQUEST);

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
