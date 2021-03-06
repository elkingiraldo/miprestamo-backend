package com.miprestamo.apps.miprestamoapi.dtos;

import java.io.Serializable;
import java.util.Set;

/**
 * Client DTO provided to the API
 * 
 * @author egiraldo
 *
 */
public class ClientDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String firstName;
	private String secondName;
	private String firstLastName;
	private String secondLastName;
	private String businessName;
	private String address;
	private String phone;
	private Set<DocumentDetailsDTO> documentDetails;

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(final String secondName) {
		this.secondName = secondName;
	}

	public String getFirstLastName() {
		return firstLastName;
	}

	public void setFirstLastName(final String firstLastName) {
		this.firstLastName = firstLastName;
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(final String secondLastName) {
		this.secondLastName = secondLastName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(final String businessName) {
		this.businessName = businessName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(final String phone) {
		this.phone = phone;
	}

	public Set<DocumentDetailsDTO> getDocumentDetails() {
		return documentDetails;
	}

	public void setDocumentDetails(final Set<DocumentDetailsDTO> documentDetails) {
		this.documentDetails = documentDetails;
	}

	@Override
	public String toString() {
		return "ClientDTO [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", firstLastName="
				+ firstLastName + ", secondLastName=" + secondLastName + ", businessName=" + businessName + ", address="
				+ address + ", phone=" + phone + ", documentDetails=" + documentDetails + "]";
	}

}
