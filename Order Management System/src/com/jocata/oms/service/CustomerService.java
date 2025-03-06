package com.jocata.oms.service;

import com.jocata.oms.Bean.CustomerBean;

public interface CustomerService {
     Object createCustomer(CustomerBean customerBean);
     Object getCustomerById(int customerId);

    void getAllCustomers();
    public boolean deleteCustomer(int customerId);
    public boolean updateCustomer(CustomerBean customerBean);
}
