package com.jocata.oms.service;

import com.jocata.oms.Bean.ProductBean;
import com.jocata.oms.entity.ProductEntity;

import java.util.Map;

public interface ProductService {
    Object addProduct(ProductBean productBean);
    Map<Integer, ProductBean> getAllProducts();
    ProductBean getProductById(int productId);
    void updateProduct(ProductBean productBean);
}
