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
	
	private String schemeName;
	
	private String description;
	
	private String eligibiltyCriteria;
	
	private String benifits;
	
	private String schemeDetails;
	
	private boolean schemeIsActive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEligibiltyCriteria() {
		return eligibiltyCriteria;
	}

	public void setEligibiltyCriteria(String eligibiltyCriteria) {
		this.eligibiltyCriteria = eligibiltyCriteria;
	}

	public String getBenifits() {
		return benifits;
	}

	public void setBenifits(String benifits) {
		this.benifits = benifits;
	}

	public String getSchemeDetails() {
		return schemeDetails;
	}

	public void setSchemeDetails(String schemeDetails) {
		this.schemeDetails = schemeDetails;
	}

	public boolean isSchemeIsActive() {
		return schemeIsActive;
	}

	public void setSchemeIsActive(boolean schemeIsActive) {
		this.schemeIsActive = schemeIsActive;
	} 

		
}