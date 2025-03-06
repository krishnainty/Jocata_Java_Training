package com.jocata.OrderManagementSystem.dao;

import com.jocata.OrderManagementSystem.entity.CustomerEntity;

import java.util.List;

public interface CustomerDao {
    Object createCustomer(CustomerEntity customerEntity);

    Object getCustomerById(int customerId);

    List<CustomerEntity> getAllCustomers();

    Object deleteCustomer(int customerId);

    Object updateCustomer(CustomerEntity customerEntity);
}
