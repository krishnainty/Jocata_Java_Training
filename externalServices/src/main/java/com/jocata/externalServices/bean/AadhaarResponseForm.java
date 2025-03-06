package com.jocata.externalServices.bean;

public class AadhaarResponseForm {
    private Demographic demographic;
    private Uid uid;
    private Photo photo;
    private Mobile mobile;
    private Email email;

    public Demographic getDemographic() {
        return demographic;
    }

    public void setDemographic(Demographic demographic) {
        this.demographic = demographic;
    }

    public Uid getUid() {
        return uid;
    }

    public void setUid(Uid uid) {
        this.uid = uid;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
