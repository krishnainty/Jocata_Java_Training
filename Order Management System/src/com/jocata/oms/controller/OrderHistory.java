package com.jocata.oms.controller;

import com.jocata.oms.dao.OrderDao;
import com.jocata.oms.dao.impl.OrderDaoImpl;
import com.jocata.oms.entity.OrderEntity;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    OrderDao orderDao=new OrderDaoImpl();
    public void getCompletedOrders(){
        List<OrderEntity> orders = orderDao.getAllOrders();
        List<OrderEntity> completedOrders = new ArrayList<>();

        for (OrderEntity order : orders) {
            if ("COMPLETED".equalsIgnoreCase(order.getStatus())) {
                completedOrders.add(order);
            }
        }

        if (completedOrders.isEmpty()) {
            System.out.println("No completed orders found.");
            return;
        }

        System.out.println("Completed Orders:");
        for (OrderEntity order : completedOrders) {
            System.out.println("Order ID: " + order.getOrderId() + ", Customer ID: " + order.getCustomerId() + ", Products: " + order.getProductIds() +
                    ", Status: " + order.getStatus());
        }
    }

}
