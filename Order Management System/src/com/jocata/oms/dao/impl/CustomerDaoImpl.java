package com.jocata.oms.dao.impl;

import com.jocata.oms.dao.CustomerDao;
import com.jocata.oms.dao.OrderDao;
import com.jocata.oms.entity.CustomerEntity;
import com.jocata.oms.entity.OrderEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerDaoImpl implements CustomerDao {
    OrderDao orderDao=new OrderDaoImpl();

    private static final String FILE_NAME = "customers.ser";

    private void saveToFile(List<CustomerEntity> customers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(customers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private List<CustomerEntity> loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return  (List<CustomerEntity>)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Object createCustomer(CustomerEntity customerEntity) {
        Random rand = new Random();
        int customerId= rand.nextInt(10000);
        List<CustomerEntity> customers = loadFromFile();
        customerEntity.setCustomerId(customerId);
        customers.add(customerEntity);
        saveToFile(customers);
        System.out.println("Customer Successfully Created Your CustomerId is: " + customerEntity.getCustomerId());
        return customerEntity;
    }

    public List<CustomerEntity> getAllCustomers() {
        return loadFromFile();
    }

    public CustomerEntity getCustomerById(int customerId) {
        List<CustomerEntity> customers = loadFromFile();


        for (CustomerEntity customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        List<OrderEntity> orders = orderDao.getAllOrders();


        for (OrderEntity order : orders) {
            if (order.getCustomerId() == customerId && !"COMPLETED".equalsIgnoreCase(order.getStatus())) {
                System.out.println("Cannot delete customer. Orders still in progress.");
                return false;
            }
        }

        List<CustomerEntity> customers = loadFromFile();
        boolean removed = customers.removeIf(customer -> customer.getCustomerId() == customerId);

        if (removed) {
            saveToFile(customers);
            System.out.println("Customer deleted successfully.");
            return true;
        } else {
            System.out.println("Customer not found.");
            return false;
        }
    }

    @Override
    public boolean updateCustomer(CustomerEntity updatedCustomer) {
        List<CustomerEntity> customers = loadFromFile();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerId() == updatedCustomer.getCustomerId()) {
                customers.set(i, updatedCustomer);
                saveToFile(customers);
                System.out.println("Customer updated successfully.");
                return true;
            }
        }
        System.out.println("Customer not found.");
        return false;
    }



}



