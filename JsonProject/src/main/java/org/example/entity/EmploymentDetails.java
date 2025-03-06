package org.example.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
public class EmploymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String employer;
    private String jobTitle;
    private BigDecimal annualIncome;
    private String employmentType;
    private int yearsAtJob;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public BigDecimal getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(BigDecimal annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public int getYearsAtJob() {
        return yearsAtJob;
    }

    public void setYearsAtJob(int yearsAtJob) {
        this.yearsAtJob = yearsAtJob;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    @OneToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
}
