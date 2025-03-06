package com.jocata.OrderManagementSystem.controller;

import com.jocata.OrderManagementSystem.bean.ProductBean;
import com.jocata.OrderManagementSystem.dao.ProductDao;
import com.jocata.OrderManagementSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/oms/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/add")
    public Object addProduct(@RequestBody ProductBean productBean){
        return productService.addProduct(productBean);


    }
    @GetMapping("/getAll")
    public Object getAllProducts(){
       return  productService.getAllProducts();

    }
    @PostMapping("/getById/{productId}")
    public Object getProductById(@PathVariable int productId){
        return productService.getProductById(productId);

    }
    @DeleteMapping("/delete/{productId}")
    public Object deleteProduct(@PathVariable int productId){
       return productService.deleteProduct(productId);

    }
    @PutMapping("/update")
    public Object updateProduct(@RequestBody ProductBean productBean){
        return productService.updateProduct(productBean);

    }
}
