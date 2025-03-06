package com.jocata.OrderManagementSystem.service.impl;

import com.jocata.OrderManagementSystem.bean.CustomerBean;
import com.jocata.OrderManagementSystem.dao.CustomerDao;
import com.jocata.OrderManagementSystem.entity.CustomerEntity;
import com.jocata.OrderManagementSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public Object createCustomer(CustomerBean customerBean) {
         CustomerEntity customerEntity=new CustomerEntity();
         customerEntity.setAddress(customerBean.getAddress());
         customerEntity.setEmail(customerBean.getEmail());
         customerEntity.setName(customerBean.getName());
         return customerDao.createCustomer(customerEntity);


    }

    @Override
    public Object getCustomerById(int customerId) {
        CustomerEntity customer= (CustomerEntity) customerDao.getCustomerById(customerId);
        System.out.println("Customer ID: " + customer.getCustomerId() + ", Name: " + customer.getName() + ", Email: " + customer.getEmail() +
                ", Address: " + customer.getAddress());
        return "Success";


    }

    @Override
    public Object getAllCustomers() {
        List<CustomerEntity> customers = customerDao.getAllCustomers();

        if (customers.isEmpty()) {
            System.out.println("No customers available.");
            return "No customers available.";
        }

        System.out.println("Registered Customers:");
        for (CustomerEntity customer : customers) {
            System.out.println("Customer ID: " + customer.getCustomerId() + ", Name: " + customer.getName() + ", Email: " + customer.getEmail() +
                    ", Address: " + customer.getAddress());
        }
         return "Success";
    }

    @Override
    public Object deleteCustomer(int customerId) {
        return customerDao.deleteCustomer(customerId);
    }

    @Override
    public Object updateCustomer(CustomerBean customerBean) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerId(customerBean.getCustomerId());
        customerEntity.setName(customerBean.getName());
        customerEntity.setAddress(customerBean.getAddress());
        customerEntity.setEmail(customerBean.getEmail());
        return customerDao.updateCustomer(customerEntity);

    }
}
