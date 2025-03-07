package com.pms.scheme_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "schemes")
public class Scheme{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Scheme name is mandatory")
	@Size(max = 100, message = "Scheme name cannot exceed 100 characters")
	private String schemeName;

	@Size(max = 500, message = "Description cannot exceed 500 characters")
	private String description;

	@NotBlank(message = "Eligibility criteria is required")
	private String eligibilityCriteria;

	@NotBlank(message = "Benefits are required")
	private String benefits;

	@Size(max = 1000, message = "Scheme details cannot exceed 1000 characters")
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
		return eligibilityCriteria;
	}

	public void setEligibiltyCriteria(String eligibiltyCriteria) {
		this.eligibilityCriteria = eligibiltyCriteria;
	}

	public String getBenifits() {
		return benefits;
	}

	public void setBenifits(String benifits) {
		this.benefits = benifits;
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