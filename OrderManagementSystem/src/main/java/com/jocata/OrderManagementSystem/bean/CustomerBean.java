package com.jocata.OrderManagementSystem.bean;

public class CustomerBean {
    private int customerId;
    private String name;
    private String email;
    private String address;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public CustomerBean(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }
    public CustomerBean() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
