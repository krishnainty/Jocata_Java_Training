package org.example.entity;

import jakarta.persistence.*;

@Entity
public class RegulatoryCompliance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String kycStatus;
    private String amlCheck;
    private String sanctionsScreening;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKycStatus() {
        return kycStatus;
    }

    public void setKycStatus(String kycStatus) {
        this.kycStatus = kycStatus;
    }

    public String getAmlCheck() {
        return amlCheck;
    }

    public void setAmlCheck(String amlCheck) {
        this.amlCheck = amlCheck;
    }

    public String getSanctionsScreening() {
        return sanctionsScreening;
    }

    public void setSanctionsScreening(String sanctionsScreening) {
        this.sanctionsScreening = sanctionsScreening;
    }

    public String getLastAudit() {
        return lastAudit;
    }

    public void setLastAudit(String lastAudit) {
        this.lastAudit = lastAudit;
    }

    public LoanApplication getLoanApplication() {
        return loanApplication;
    }

    public void setLoanApplication(LoanApplication loanApplication) {
        this.loanApplication = loanApplication;
    }

    private String lastAudit;
    @OneToOne
    @JoinColumn(name = "application_id")
    private LoanApplication loanApplication;
}
