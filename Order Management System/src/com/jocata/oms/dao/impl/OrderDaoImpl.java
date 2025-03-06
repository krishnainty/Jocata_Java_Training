package com.jocata.oms.dao.impl;

import com.jocata.oms.dao.OrderDao;
import com.jocata.oms.entity.OrderEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderDaoImpl implements OrderDao {

    private static final String FILE_NAME = "orders.ser";

    private void saveToFile(List<OrderEntity> orders) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(orders);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private List<OrderEntity> loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<OrderEntity>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Object createOrder(OrderEntity orderEntity) {
        Random rand = new Random();
        List<OrderEntity> orders = loadFromFile();
        int orderId= rand.nextInt(10000);
        orderEntity = new OrderEntity(orderId, orderEntity.getCustomerId(), orderEntity.getProductIds(), "Pending");
        orders.add(orderEntity);
        saveToFile(orders);
        System.out.println("Order Created Successfully! Order ID: " + orderEntity.getOrderId());
        return orderEntity;
    }

    @Override
    public OrderEntity getOrderById(int orderId) {
        List<OrderEntity> orders = loadFromFile();
        for (OrderEntity order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return loadFromFile();
    }

    @Override
    public List<OrderEntity> getAllOrders(int customerId) {
        List<OrderEntity> allOrders = loadFromFile();
        List<OrderEntity> customerOrders = new ArrayList<>();

        for (OrderEntity order : allOrders) {
            if (order.getCustomerId() == customerId) {
                customerOrders.add(order);
            }
        }
        if (customerOrders.isEmpty()) {
            System.out.println("No orders found for Customer ID: " + customerId);
            return customerOrders;
        }

        System.out.println("Orders for Customer ID: " + customerId);
        for (OrderEntity order : customerOrders) {
            System.out.println("Order ID: " + order.getOrderId() +
                    ", Products: " + order.getProductIds() +
                    ", Status: " + order.getStatus());
        }

        return customerOrders;

    }

    @Override
    public void updateOrder(OrderEntity updatedOrder) {
        List<OrderEntity> orders = loadFromFile();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderId() == updatedOrder.getOrderId()) {
                orders.set(i, updatedOrder);
                saveToFile(orders);
                System.out.println("Order ID " + updatedOrder.getOrderId() + " updated successfully.");
                return;
            }
        }
        System.out.println("Order not found!");
    }

    @Override
    public void deleteOrder(int orderId) {
        List<OrderEntity> orders = loadFromFile();
        boolean removed = orders.removeIf(order -> order.getOrderId() == orderId);
        if (removed) {
            saveToFile(orders);
            System.out.println("Order ID " + orderId + " deleted successfully.");
        } else {
            System.out.println("Order not found!");
        }
    }
}
