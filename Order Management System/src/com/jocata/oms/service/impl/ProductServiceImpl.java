package com.jocata.oms.service.impl;

import com.jocata.oms.Bean.ProductBean;
import com.jocata.oms.dao.ProductDao;
import com.jocata.oms.dao.impl.ProductDaoImpl;
import com.jocata.oms.entity.ProductEntity;
import com.jocata.oms.service.ProductService;

import java.util.Map;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao=new ProductDaoImpl();
    @Override
    public Object addProduct(ProductBean productBean) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(productBean.getProductId());
        productEntity.setProductName(productBean.getProductName());
        productEntity.setPrice(productBean.getPrice());
        productEntity.setStock(productBean.getStock());

        productDao.addProduct(productEntity);
        return null;
    }

    @Override
    public Map<Integer, ProductBean> getAllProducts() {
        Map<Integer, ProductEntity> productEntityMap = productDao.getAllProducts();

        if (productEntityMap.isEmpty()) {
            System.out.println("No products available.");
            return null;
        }

        System.out.println("Available Products:");
        for(int i:productEntityMap.keySet()){
            ProductEntity entity = productEntityMap.get(i);
            System.out.println("Product ID: " + entity.getProductId() +
                    ", Name: " + entity.getProductName() +
                    ", Price: " + entity.getPrice() +
                    ", Stock: " + entity.getStock());
        }

        return null;
    }

    @Override
    public ProductBean getProductById(int productId) {
        ProductEntity productEntity = productDao.getProductById(productId);
        if (productEntity != null) {
            return new ProductBean(productEntity.getProductName(), productEntity.getPrice(), productEntity.getStock());
        }
        return null;
    }

    @Override
    public void updateProduct(ProductBean productBean) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(productBean.getProductId());
        productEntity.setProductName(productBean.getProductName());
        productEntity.setPrice(productBean.getPrice());
        productEntity.setStock(productBean.getStock());
        productDao.updateProduct(productEntity);


    }
}
