package com.miprestamo.apps.miprestamoapi.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity for representing DB information related to identification documents
 * 
 * @author egiraldo
 *
 */
@Entity
public class IdentificationDocument implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String type;
	private String prefix;

	@OneToMany(mappedBy = "identificationDocument")
	private Set<DocumentDetails> documentDetails;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public Set<DocumentDetails> getDocumentDetails() {
		return documentDetails;
	}

	public void setDocumentDetails(final Set<DocumentDetails> documentDetails) {
		this.documentDetails = documentDetails;
	}

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(final String prefix) {
		this.prefix = prefix;
	}

	@Override
	public String toString() {
		return "IdentificationDocument [id=" + id + ", documentDetails=" + documentDetails + ", type=" + type
				+ ", prefix=" + prefix + "]";
	}

}
