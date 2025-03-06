package com.jocata.OrderManagementSystem.dao.impl;

import com.jocata.OrderManagementSystem.dao.ProductDao;
import com.jocata.OrderManagementSystem.entity.ProductEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    @Override
    public Object addProduct(ProductEntity productEntity) {
        try {
            entityManager.persist(productEntity);
            return "Product added successfully!";
        } catch (Exception e) {
            return "Error while adding Product: " + e.getMessage();
        }
    }
    @Transactional
    @Override
    public List<ProductEntity> getAllProducts() {
        try {
            TypedQuery<ProductEntity> query = entityManager.createQuery("SELECT pro FROM ProductEntity pro", ProductEntity.class);
            return query.getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
    @Transactional
    @Override
    public Object getProductById(int productId) {
        try {
            return entityManager.find(ProductEntity.class, productId);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Transactional
    @Override
    public Object deleteProduct(int productId) {
        try {


            ProductEntity product = entityManager.find(ProductEntity.class, productId);
            if (product != null) {
                entityManager.remove(product);
                return "Product deleted successfully";
            }
            return "Product not found";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    @Transactional
    @Override
    public Object updateProduct(ProductEntity productEntity) {
        try {
            entityManager.merge(productEntity);
            return "Product updated successfully";
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
