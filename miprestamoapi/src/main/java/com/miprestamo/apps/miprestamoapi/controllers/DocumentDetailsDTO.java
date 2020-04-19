package com.miprestamo.apps.miprestamoapi.controllers;

import java.io.Serializable;

public class DocumentDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String documentNumber;
	private String documentType;

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

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(final String documentType) {
		this.documentType = documentType;
	}

}
