package com.pms.scheme_management.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "schemes")
public class Scheme{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int schemeId;

	@NotBlank(message = "Scheme name is mandatory")
	@Size(max = 5, message = "Scheme name cannot exceed 5 characters")
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

	@OneToMany(mappedBy = "scheme", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Policy> policies;

	@OneToMany(mappedBy = "scheme", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Feedback> feedbacks;

	public int getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(int id) {
		this.schemeId = id;
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



	public String getEligibilityCriteria() {
		return eligibilityCriteria;
	}

	public void setEligibilityCriteria (String eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits (String benefits) {
		this.benefits = benefits;
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

	@Override
	public String toString() {
		return "Scheme{" +
				"id=" + schemeId +
				", schemeName='" + schemeName + '\'' +
				", description='" + description + '\'' +
				", eligibiltyCriteria='" + eligibilityCriteria + '\'' +
				", benifits='" + benefits + '\'' +
				", schemeIsActive=" + schemeIsActive +
				'}';
	}
}