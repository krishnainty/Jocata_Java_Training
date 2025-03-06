package com.jocata.OrderManagementSystem.bean;

import java.sql.Date;
import java.util.List;

public class OrderBean {
    private int orderId;

    private CustomerBean customerId;
    private List<ProductBean> productIds;
    private double orderTotal;
    private Date orderDate;
    private String status;

    public OrderBean() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public CustomerBean getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerBean customerId) {
        this.customerId = customerId;
    }

    public List<ProductBean> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<ProductBean> productIds) {
        this.productIds = productIds;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
