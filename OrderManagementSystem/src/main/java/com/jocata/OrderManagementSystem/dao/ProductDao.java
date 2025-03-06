package com.jocata.OrderManagementSystem.dao;

import com.jocata.OrderManagementSystem.entity.ProductEntity;

import java.util.List;

public interface ProductDao {
    Object addProduct(ProductEntity productEntity);

    List<ProductEntity> getAllProducts();

    Object getProductById(int productId);

    Object deleteProduct(int productId);

    Object updateProduct(ProductEntity productEntity);
}
