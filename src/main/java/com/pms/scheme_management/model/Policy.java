package com.pms.scheme_management.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "policy")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int policyId;

    @Column(name = "policy_name", nullable = false)
    private String policyName;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", nullable = false, updatable = false)
    private Date startDate;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private int years;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String annuity;

	@ManyToOne
	@JoinColumn(name = "scheme_id", nullable = false)
	private Scheme scheme;


	public Scheme getScheme() {
		return scheme;
	}

	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int id) {
		this.policyId = id;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAnnuity() {
		return annuity;
	}

	public void setAnnuity(String annuity) {
		this.annuity = annuity;
	}

	@Override
	public String toString() {
		return "Policy [id=" + policyId + ", policyName=" + policyName + ", startDate=" + startDate + ", amount=" + amount
				+ ", years=" + years + ", status=" + status + ", annuity=" + annuity + "]";
	}
    
    
    
}
