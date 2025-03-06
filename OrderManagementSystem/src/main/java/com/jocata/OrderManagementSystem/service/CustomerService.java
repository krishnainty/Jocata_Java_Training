package com.jocata.OrderManagementSystem.service;

import com.jocata.OrderManagementSystem.bean.CustomerBean;

public interface CustomerService {
    Object createCustomer(CustomerBean customerBean);

    Object getCustomerById(int customerId);

    Object getAllCustomers();

    Object deleteCustomer(int customerId);

    Object updateCustomer(CustomerBean customerBean);
}
