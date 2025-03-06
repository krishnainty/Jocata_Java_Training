package com.jocata.oms.controller;

import com.jocata.oms.Bean.ProductBean;
import com.jocata.oms.service.ProductService;
import com.jocata.oms.service.impl.ProductServiceImpl;

import java.util.Map;

public class ProductController {
    ProductService productService=new ProductServiceImpl();
    public Object addProduct(ProductBean productBean){
        productService.addProduct(productBean);
        return null;

    }
    public Map<Integer, ProductBean> getAllProducts(){
        productService.getAllProducts();
        return null;
    }
    public ProductBean getProductById(int productId){
        productService.getProductById(productId);
        return null;
    }
    public void updateProduct(ProductBean productBean){
        productService.updateProduct(productBean);
        return ;
    }
}
