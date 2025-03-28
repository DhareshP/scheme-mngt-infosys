package com.pms.scheme_management.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Policy")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String policyName;

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
    @JoinColumn(name = "scheme_id")
    private Scheme scheme;

    public Scheme getScheme() {
        return scheme;
    }

    public void setScheme(Scheme scheme) {
        this.scheme = scheme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
