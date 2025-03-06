package org.example.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String applicationId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public LoanDetails getLoanDetails() {
        return loanDetails;
    }

    public void setLoanDetails(LoanDetails loanDetails) {
        this.loanDetails = loanDetails;
    }

    public List<Collateral> getCollateral() {
        return collateral;
    }

    public void setCollateral(List<Collateral> collateral) {
        this.collateral = collateral;
    }

    public RiskAssessment getRiskAssessment() {
        return riskAssessment;
    }

    public void setRiskAssessment(RiskAssessment riskAssessment) {
        this.riskAssessment = riskAssessment;
    }

    public RegulatoryCompliance getRegulatoryCompliance() {
        return regulatoryCompliance;
    }

    public void setRegulatoryCompliance(RegulatoryCompliance regulatoryCompliance) {
        this.regulatoryCompliance = regulatoryCompliance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_details_id")
    private LoanDetails loanDetails;
    @OneToMany(mappedBy = "loanApplication", cascade = CascadeType.ALL)
    private List<Collateral>collateral;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "risk_assessment_id")
    private RiskAssessment riskAssessment;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regulatory_compliance_id")
    private RegulatoryCompliance regulatoryCompliance;
    @OneToMany(mappedBy = "loanApplication", cascade = CascadeType.ALL)
    private List<Transaction>transactions;
    private String status;
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
}
