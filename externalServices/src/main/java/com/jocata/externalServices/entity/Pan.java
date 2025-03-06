package com.jocata.externalServices.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Pan")
public class Pan {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "panNo")
    private String panNo;
    @Column(name = "panStatus")
    private String panStatus;
    private String name;
    private String dob;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getPanStatus() {
        return panStatus;
    }

    public void setPanStatus(String panStatus) {
        this.panStatus = panStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


}
