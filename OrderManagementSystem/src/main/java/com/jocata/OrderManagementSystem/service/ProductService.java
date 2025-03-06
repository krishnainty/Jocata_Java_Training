package com.jocata.OrderManagementSystem.service;

import com.jocata.OrderManagementSystem.bean.ProductBean;

public interface ProductService {
    Object addProduct(ProductBean productBean);

    Object getAllProducts();

    Object getProductById(int productId);

    Object deleteProduct(int productId);

    Object updateProduct(ProductBean productBean);
}
