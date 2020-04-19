package com.miprestamo.apps.miprestamoapi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// private List<String> documentType;
	private String firstName;
	private String secondName;
	private String fisrtLastName;
	private String secondLastName;
	private String businessName;
	private String address;
	private String phone;

}
