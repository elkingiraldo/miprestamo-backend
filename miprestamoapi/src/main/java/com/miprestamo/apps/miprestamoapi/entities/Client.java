package com.miprestamo.apps.miprestamoapi.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.array.ListArrayType;

@Entity
@TypeDef(name = "list-array", typeClass = ListArrayType.class)
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Type(type = "list-array")
	private List<Integer> documentList;

	private String firstName;
	private String secondName;
	private String fisrtLastName;
	private String secondLastName;
	private String businessName;
	private String address;
	private String phone;

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public List<Integer> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(final List<Integer> documentList) {
		this.documentList = documentList;
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

	public String getFisrtLastName() {
		return fisrtLastName;
	}

	public void setFisrtLastName(final String fisrtLastName) {
		this.fisrtLastName = fisrtLastName;
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

	@Override
	public String toString() {
		return "Client [id=" + id + ", documentList=" + documentList + ", firstName=" + firstName + ", secondName="
				+ secondName + ", fisrtLastName=" + fisrtLastName + ", secondLastName=" + secondLastName
				+ ", businessName=" + businessName + ", address=" + address + ", phone=" + phone + "]";
	}

}
