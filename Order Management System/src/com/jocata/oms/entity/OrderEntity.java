package com.jocata.oms.entity;

import java.io.Serializable;
import java.util.List;

public class OrderEntity implements Serializable {
    private int orderId;
    private int customerId;
    private List<Integer> productIds;

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

    private String status;

    public OrderEntity(int orderId, int customerId, List<Integer> productIds, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productIds = productIds;
        this.status = status;
    }
}
