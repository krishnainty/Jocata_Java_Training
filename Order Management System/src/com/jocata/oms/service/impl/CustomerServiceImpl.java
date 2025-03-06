package com.jocata.oms.service.impl;

import com.jocata.oms.Bean.CustomerBean;
import com.jocata.oms.dao.CustomerDao;
import com.jocata.oms.dao.impl.CustomerDaoImpl;
import com.jocata.oms.entity.CustomerEntity;
import com.jocata.oms.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public Object createCustomer(CustomerBean customerBean) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerId(customerBean.getCustomerId());
        customerEntity.setName(customerBean.getName());
        customerEntity.setAddress(customerBean.getAddress());
        customerEntity.setEmail(customerBean.getEmail());
        customerDao.createCustomer(customerEntity);
        return null;
    }

    @Override
    public Object getCustomerById(int customerId) {
        CustomerEntity customerEntity = customerDao.getCustomerById(customerId);


        return null;

    }

    @Override
    public void getAllCustomers() {
        List<CustomerEntity> customers = customerDao.getAllCustomers();

        if (customers.isEmpty()) {
            System.out.println("No customers available.");
            return;
        }

        System.out.println("Registered Customers:");
        for (CustomerEntity customer : customers) {
            System.out.println("Customer ID: " + customer.getCustomerId() + ", Name: " + customer.getName() + ", Email: " + customer.getEmail() +
                    ", Address: " + customer.getAddress());
        }
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        customerDao.deleteCustomer(customerId);
        return true;
    }

    @Override
    public boolean updateCustomer(CustomerBean customerBean) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerId(customerBean.getCustomerId());
        customerEntity.setName(customerBean.getName());
        customerEntity.setAddress(customerBean.getAddress());
        customerEntity.setEmail(customerBean.getEmail());
        customerDao.updateCustomer(customerEntity);

        return true;
    }
}
