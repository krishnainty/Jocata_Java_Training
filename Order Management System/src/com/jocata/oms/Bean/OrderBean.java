package com.jocata.oms.Bean;

import java.util.List;

public class OrderBean {

    private int orderId;
    private int customerId;
    private List<Integer> productIds;
    private String status;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderBean(int customerId, List<Integer> productIds, String status) {

        this.customerId = customerId;
        this.productIds = productIds;
        this.status = "Pending";
    }
}
