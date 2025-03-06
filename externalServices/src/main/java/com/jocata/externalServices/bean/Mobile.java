package com.jocata.externalServices.bean;

public class Mobile {
    private String mobile;
    private String maskedMobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    private String hashedMobile;

    public String getMaskedMobile() {
        return maskedMobile;
    }

    public void setMaskedMobile(String maskedMobile) {
        this.maskedMobile = maskedMobile;
    }

    public String getHashedMobile() {
        return hashedMobile;
    }

    public void setHashedMobile(String hashedMobile) {
        this.hashedMobile = hashedMobile;
    }
}
