package com.jocata.oms.controller;

import com.jocata.oms.dao.ProductDao;
import com.jocata.oms.dao.impl.ProductDaoImpl;
import com.jocata.oms.entity.ProductEntity;

import java.util.Map;

public class InventoryManager {
    private ProductDao productDao;

    public InventoryManager() {
        this.productDao = new ProductDaoImpl();
    }


    public void addProductStock(int productId, int quantity) {
        ProductEntity product = productDao.getProductById(productId);
        if (product == null) {
            System.out.println("Product Not Found! ID: " + productId);
            return;
        }

        product.setStock(product.getStock() + quantity);
        boolean isUpdated = productDao.updateProduct(product);

        if (isUpdated) {
            System.out.println(quantity + " units added. New stock for Product ID " + productId + ": " + product.getStock());
        } else {
            System.out.println("Failed to add stock for Product ID: " + productId);
        }
    }


    public void reduceProductStock(int productId, int quantity) {
        ProductEntity product = productDao.getProductById(productId);
        if (product == null) {
            System.out.println("Product Not Found! ID: " + productId);
            return;
        }

        if (product.getStock() >= quantity) {
            product.setStock(product.getStock() - quantity);
            boolean isUpdated = productDao.updateProduct(product);

            if (isUpdated) {
                System.out.println(quantity + " units reduced Remaining stock for Product ID " + productId + ": " + product.getStock());
            } else {
                System.out.println("Failed to update stock for Product ID " + productId);
            }
        } else {
            System.out.println("Insufficient stock for Product ID " + productId + " Available: " + product.getStock());
        }
    }


    public int getProductStock(int productId) {
        ProductEntity product = productDao.getProductById(productId);
        if (product == null) {
            System.out.println("Product Not Found! ID: " + productId);
            return -1;
        }
        System.out.println("Product ID: " + product.getProductId() + ", Name: " + product.getProductName() +
                ", Stock " + product.getStock());;
        return product.getStock();
    }


    public void getAllStock() {
        Map<Integer, ProductEntity> products = productDao.getAllProducts();

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("Product Stock List:");
        for (ProductEntity product : products.values()) {
            System.out.println("Product ID: " + product.getProductId() + ", Name: " + product.getProductName() +
                    ", Stock: " + product.getStock());
        }
    }
}
