package com.jocata.oms.dao.impl;

import com.jocata.oms.dao.ProductDao;
import com.jocata.oms.entity.ProductEntity;

import java.io.*;
import java.util.*;

public class ProductDaoImpl implements ProductDao {

    private static final String FILE_NAME = "products.ser";
    private Map<Integer, ProductEntity> productMap;

    public ProductDaoImpl() {
        this.productMap = loadFromFile();
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(productMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private Map<Integer, ProductEntity> loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new HashMap<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Map<Integer, ProductEntity>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    @Override
    public ProductEntity addProduct(ProductEntity productEntity) {
        Random rand = new Random();
        int productId= rand.nextInt(10000);
        productEntity.setProductId(productId);
        productMap.put(productEntity.getProductId(), productEntity);
        saveToFile();
        System.out.println("Product Successfully Added. Product ID: " + productEntity.getProductId());
        return productEntity;
    }

    @Override
    public ProductEntity getProductById(int productId) {
        return productMap.get(productId);
    }

    @Override
    public Map<Integer, ProductEntity> getAllProducts() {
        return productMap;
    }
    @Override
    public boolean updateProduct(ProductEntity updatedProduct) {
        if (productMap.containsKey(updatedProduct.getProductId())) {
            productMap.put(updatedProduct.getProductId(), updatedProduct);
            saveToFile();
            System.out.println("Product Updated Successfully. Product ID: " + updatedProduct.getProductId());
            return true;
        } else {
            System.out.println("Product Not Found! ID: " + updatedProduct.getProductId());
            return false;
        }
    }


}
