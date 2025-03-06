package com.jocata.OrderManagementSystem.dao.impl;

import com.jocata.OrderManagementSystem.dao.OrderDao;
import com.jocata.OrderManagementSystem.entity.CustomerEntity;
import com.jocata.OrderManagementSystem.entity.OrderEntity;
import com.jocata.OrderManagementSystem.entity.ProductEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Object createOrder(OrderEntity orderEntity) {
        try {

            CustomerEntity customer = entityManager.find(CustomerEntity.class, orderEntity.getCustomerId().getCustomerId());
            if (customer == null) {
                return "Customer does not exist  " + orderEntity.getCustomerId().getCustomerId();
            }


            List<ProductEntity> validProducts = new ArrayList<>();
            for (ProductEntity product : orderEntity.getProductIds()) {
                ProductEntity existingProduct = entityManager.find(ProductEntity.class, product.getProductId());
                if (existingProduct == null) {
                    return "Product does not exist with ID: " + product.getProductId();
                }
                validProducts.add(existingProduct);
            }


            orderEntity.setCustomerId(customer);
            orderEntity.setProductIds(validProducts);


            entityManager.persist(orderEntity);
            return orderEntity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public OrderEntity getOrderById(int orderId) {

        try {
            return entityManager.find(OrderEntity.class, orderId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object deleteOrder(int orderId) {
        try {
            OrderEntity order = entityManager.find(OrderEntity.class, orderId);
            if (order != null) {
                entityManager.remove(order);
                return "Order deleted successfully";
            }
            return "Order not found";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    @Override
    public List<OrderEntity> getAllOrders() {
        try {
            TypedQuery<OrderEntity> query = entityManager.createQuery("SELECT orders FROM OrderEntity orders", OrderEntity.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
