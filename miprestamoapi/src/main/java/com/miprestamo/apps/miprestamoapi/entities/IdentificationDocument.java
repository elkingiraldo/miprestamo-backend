package com.miprestamo.apps.miprestamoapi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IdentificationDocument {

	@Id
	private String id;

	private String type;
	private String prefix;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
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

}
