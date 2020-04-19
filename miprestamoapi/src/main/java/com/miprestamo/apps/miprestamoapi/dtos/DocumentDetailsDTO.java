package com.miprestamo.apps.miprestamoapi.dtos;

import java.io.Serializable;

/**
 * Document Details DTO provided to the API
 * 
 * @author egiraldo
 *
 */
public class DocumentDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String documentNumber;
	private String identificationDocumentId;

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(final String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getIdentificationDocumentId() {
		return identificationDocumentId;
	}

	public void setIdentificationDocumentId(final String identificationDocumentId) {
		this.identificationDocumentId = identificationDocumentId;
	}

	@Override
	public String toString() {
		return "DocumentDetailsDTO [id=" + id + ", documentNumber=" + documentNumber + ", identificationDocumentId="
				+ identificationDocumentId + "]";
	}

}
