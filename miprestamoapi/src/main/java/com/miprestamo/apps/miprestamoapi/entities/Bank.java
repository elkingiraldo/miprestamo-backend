package com.miprestamo.apps.miprestamoapi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity for representing DB information related to partner banks
 * 
 * @author elkin.giraldo
 *
 */
@Entity
public class Bank implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
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
		return "Bank [id=" + id + ", name=" + name + "]";
	}

}
