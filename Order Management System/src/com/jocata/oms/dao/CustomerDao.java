package com.jocata.oms.dao;

import com.jocata.oms.Bean.CustomerBean;
import com.jocata.oms.entity.CustomerEntity;

import java.util.List;

public interface CustomerDao {
    Object createCustomer(CustomerEntity customerEntity);
      CustomerEntity getCustomerById(int customerId);
     List<CustomerEntity> getAllCustomers();
    public boolean deleteCustomer(int customerId);
    public boolean updateCustomer(CustomerEntity updatedCustomer);

}
