package com.jocata.OrderManagementSystem.dao.impl;

import com.jocata.OrderManagementSystem.dao.CustomerDao;
import com.jocata.OrderManagementSystem.entity.CustomerEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Object createCustomer(CustomerEntity customerEntity) {
        try {
            entityManager.persist(customerEntity);
            return "Customer created successfully!";
        } catch (Exception e) {
            return "Error while creating Customer: " + e.getMessage();
        }
    }

    @Transactional
    @Override
    public Object getCustomerById(int customerId) {
        try {
            return entityManager.find(CustomerEntity.class, customerId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    @Transactional
    @Override
    public List<CustomerEntity> getAllCustomers() {
        try {
            TypedQuery<CustomerEntity> query = entityManager.createQuery("SELECT cus FROM CustomerEntity cus", CustomerEntity.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Transactional
    @Override
    public Object deleteCustomer(int customerId) {
        try {
            CustomerEntity customer = entityManager.find(CustomerEntity.class, customerId);
            if (customer != null) {
                entityManager.remove(customer);
                return "Customer deleted successfully";
            }
            return "Customer not found";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Transactional
    @Override
    public Object updateCustomer(CustomerEntity customerEntity) {
        try {
            entityManager.merge(customerEntity);
            return "Customer updated successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
