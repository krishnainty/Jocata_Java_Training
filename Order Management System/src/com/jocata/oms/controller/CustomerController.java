package com.jocata.oms.controller;

import com.jocata.oms.Bean.CustomerBean;
import com.jocata.oms.entity.CustomerEntity;
import com.jocata.oms.service.CustomerService;
import com.jocata.oms.service.impl.CustomerServiceImpl;

public class CustomerController {
    public CustomerService customerService=new CustomerServiceImpl();
    public Object createCustomer(CustomerBean customerBean){
        customerService.createCustomer(customerBean);

        return null;
    }
    public Object getCustomerById(int customerId){
        customerService.getCustomerById(customerId);

        return null;

    }
    public void getAllCustomers(){
        customerService.getAllCustomers();

    }
    public boolean deleteCustomer(int customerId){
         customerService.deleteCustomer(customerId);
        return true;
    }
    public boolean updateCustomer(CustomerBean customerBean){
        customerService.updateCustomer(customerBean);
        return true;
    }
}
