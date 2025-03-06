package com.jocata.oms.dao;

import com.jocata.oms.entity.ProductEntity;

import java.util.List;
import java.util.Map;

public interface ProductDao {

    Object addProduct(ProductEntity productEntity);
    Map<Integer, ProductEntity> getAllProducts();
    ProductEntity getProductById(int productId);
    boolean updateProduct(ProductEntity updatedProduct);

}
