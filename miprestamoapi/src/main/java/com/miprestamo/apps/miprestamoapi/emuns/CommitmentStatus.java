package com.miprestamo.apps.miprestamoapi.emuns;

/**
 * Status that can have a commitment
 * 
 * @author elkin.giraldo
 *
 */
public enum CommitmentStatus {

	PAYED("RC-001"), PENDING("RC-002");

	private String id;

	private CommitmentStatus(final String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
