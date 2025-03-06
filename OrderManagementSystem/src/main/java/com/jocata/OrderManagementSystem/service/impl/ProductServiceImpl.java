package com.jocata.OrderManagementSystem.service.impl;

import com.jocata.OrderManagementSystem.bean.ProductBean;
import com.jocata.OrderManagementSystem.dao.ProductDao;
import com.jocata.OrderManagementSystem.entity.ProductEntity;
import com.jocata.OrderManagementSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;


    @Override
    public Object addProduct(ProductBean productBean) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(productBean.getProductId());
        productEntity.setProductName(productBean.getProductName());
        productEntity.setPrice(productBean.getPrice());
        productEntity.setStock(productBean.getStock());

        return productDao.addProduct(productEntity);

    }

    @Override
    public Object getAllProducts() {
        List<ProductEntity> li= productDao.getAllProducts();
        for(ProductEntity entity:li){
            System.out.println("Product ID: " + entity.getProductId() +
                    ", Name: " + entity.getProductName() +
                    ", Price: " + entity.getPrice() +
                    ", Stock: " + entity.getStock());
        }
        return "Success";

    }

    @Override
    public Object getProductById(int productId) {
        ProductEntity entity= (ProductEntity) productDao.getProductById(productId);
        System.out.println("Product ID: " + entity.getProductId() +
                ", Name: " + entity.getProductName() +
                ", Price: " + entity.getPrice() +
                ", Stock: " + entity.getStock());
        return "Success";

    }

    @Override
    public Object deleteProduct(int productId) {
        return productDao.deleteProduct(productId);
    }

    @Override
    public Object updateProduct(ProductBean productBean) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(productBean.getProductId());
        productEntity.setProductName(productBean.getProductName());
        productEntity.setPrice(productBean.getPrice());
        productEntity.setStock(productBean.getStock());
        return productDao.updateProduct(productEntity);
    }
}
