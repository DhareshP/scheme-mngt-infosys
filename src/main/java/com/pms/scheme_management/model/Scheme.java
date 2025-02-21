package com.pms.scheme_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "schemes")
public class Scheme{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String SchemeName;
	
	private String SchemeDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchemeName() {
		return SchemeName;
	}

	public void setSchemeName(String schemeName) {
		SchemeName = schemeName;
	}

	public String getSchemeDetails() {
		return SchemeDetails;
	}

	public void setSchemeDetails(String schemeDetails) {
		SchemeDetails = schemeDetails;
	}
	
	
	
	
	
	
}