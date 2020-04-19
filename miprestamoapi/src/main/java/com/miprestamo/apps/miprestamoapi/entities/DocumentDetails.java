package com.miprestamo.apps.miprestamoapi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity for representing DB information related to client document Details
 * 
 * @author egiraldo
 *
 */
@Entity
public class DocumentDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String documentNumber;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "identification_document_id")
	private IdentificationDocument identificationDocument;

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(final Client client) {
		this.client = client;
	}

	public IdentificationDocument getIdentificationDocument() {
		return identificationDocument;
	}

	public void setIdentificationDocument(final IdentificationDocument identificationDocument) {
		this.identificationDocument = identificationDocument;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(final String documentNumber) {
		this.documentNumber = documentNumber;
	}

	@Override
	public String toString() {
		return "DocumentDetails [id=" + id + ", client=" + client + ", identificationDocument=" + identificationDocument
				+ ", documentNumber=" + documentNumber + "]";
	}

}
