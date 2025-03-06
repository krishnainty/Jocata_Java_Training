package com.jocata.OrderManagementSystem.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "name",  length = 255)
    private String productName;

    @Column(name = "price")
    private double price;

    @Column(name = "stock_quantity")
    private int stock;

    public ProductEntity() {
    }

    public ProductEntity(String productName, double price, int stock) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }


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
}
