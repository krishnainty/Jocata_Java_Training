package com.jocata.oms.Bean;

public class ProductBean {
    private int productId;
    private String productName;
    private double price;
    private int stock;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public ProductBean(String pname, double price, int stock) {
        this.productName = pname;
        this.price = price;
        this.stock = stock;
    }
}
