package com.miprestamo.apps.miprestamoapi.dtos;

import java.io.Serializable;

public class IdentificationDocumentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

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

	@Override
	public String toString() {
		return "IdentificationDocumentDTO [id=" + id + ", type=" + type + ", prefix=" + prefix + "]";
	}

}
