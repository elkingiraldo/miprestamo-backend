package com.miprestamo.apps.miprestamoapi.dtos;

import java.io.Serializable;

/**
 * Bank DTO provided to the API
 * 
 * @author elkin.giraldo
 *
 */
public class BankDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BankDTO [id=" + id + ", name=" + name + "]";
	}

}
