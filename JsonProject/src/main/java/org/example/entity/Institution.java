package org.example.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String institutionId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "ecosystem_id")
    private LoanEcosystem ecosystem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LoanEcosystem getEcosystem() {
        return ecosystem;
    }

    public void setEcosystem(LoanEcosystem ecosystem) {
        this.ecosystem = ecosystem;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    @OneToMany(mappedBy = "institution", cascade = CascadeType.ALL)
    private List<Branch>branches;
}
