package com.jocata.oms.Bean;

public class PaymentBean {
    private int paymentId;
    private int orderId;
    private double amount;
    private String status;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public PaymentBean( int orderId, double amount, String status) {

        this.orderId = orderId;
        this.amount = amount;
        this.status = status;
    }
}
