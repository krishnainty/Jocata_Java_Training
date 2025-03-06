package com.jocata.oms.controller;

import com.jocata.oms.dao.OrderDao;
import com.jocata.oms.dao.ProductDao;
import com.jocata.oms.dao.impl.OrderDaoImpl;
import com.jocata.oms.dao.impl.ProductDaoImpl;
import com.jocata.oms.entity.OrderEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OrderManager {
    private OrderDao orderDao;
    private ProductDao productDao;
    private InventoryManager inventoryManager;
    private ExecutorService executorService;

    public OrderManager() {
        this.orderDao = new OrderDaoImpl();
        this.productDao = new ProductDaoImpl();
        this.inventoryManager = new InventoryManager();
        this.executorService = Executors.newFixedThreadPool(5);
    }


//    public void createOrder(int customerId, List<Integer> productIds) {
//        List<Integer> unavailableProducts = new ArrayList<>();
//        for (int productId : productIds) {
//            int stock = inventoryManager.getProductStock(productId);
//            if (stock <= 0) {
//                unavailableProducts.add(productId);
//            }
//        }
//
//        if (!unavailableProducts.isEmpty()) {
//            System.out.println("Order cannot be placed. Out of stock products: " + unavailableProducts);
//            return;
//        }
//
//        for (int productId : productIds) {
//            inventoryManager.reduceProductStock(productId, 1); // Assuming each order takes 1 unit per product
//        }
//
//        OrderEntity order = new OrderEntity(orderDao.getAllOrders().size()+1, customerId, productIds, "PLACED");
//        orderDao.createOrder(order);
//
//        System.out.println("Order placed successfully! Order ID: " + order.getOrderId());
//    }


    public void createOrder(int customerId, List<Integer> productIds) {
        executorService.submit(() -> processOrderCreation(customerId, productIds));

    }

    private void processOrderCreation(int customerId, List<Integer> productIds) {
        List<Integer> unavailableProducts = new ArrayList<>();
        for (int productId : productIds) {
            int stock = inventoryManager.getProductStock(productId);
            if (stock <= 0) {
                unavailableProducts.add(productId);
            }
        }

        if (!unavailableProducts.isEmpty()) {
            System.out.println("Order cannot be placed Out of stock products: " + unavailableProducts);
            return;
        }

        for (int productId : productIds) {
            inventoryManager.reduceProductStock(productId, 1);
        }

        OrderEntity order = new OrderEntity(orderDao.getAllOrders().size() + 1, customerId, productIds, "PLACED");
        orderDao.createOrder(order);

        System.out.println("Order placed successfully Order ID: " + order.getOrderId());
    }

    public void shutdownExecutor() {
        executorService.shutdown();
    }


    public void processOrder(int orderId) {
        OrderEntity order = orderDao.getOrderById(orderId);
        if (order == null) {
            System.out.println("Order Not Found! ID: " + orderId);
            return;
        }

        order.setStatus("PROCESSED");
        orderDao.updateOrder(order);
        System.out.println("Order ID " + orderId + " has been processed.");
    }

    public void completeOrder(int orderId) {
        OrderEntity order = orderDao.getOrderById(orderId);
        if (order == null) {
            System.out.println("Order Not Found! ID: " + orderId);
            return;
        }

        order.setStatus("Completed");
        orderDao.updateOrder(order);
        System.out.println("Order ID " + orderId + " has been completed.");
    }


    public void cancelOrder(int orderId) {
        OrderEntity order = orderDao.getOrderById(orderId);
        if (order == null) {
            System.out.println("Order Not Found! ID: " + orderId);
            return;
        }


        for (int productId : order.getProductIds()) {
            inventoryManager.addProductStock(productId, 1);
        }

        order.setStatus("CANCELLED");
        orderDao.updateOrder(order);
        System.out.println("Order ID " + orderId + " has been cancelled and stock restored.");
    }


    public void getOrderById(int orderId) {
        OrderEntity order = orderDao.getOrderById(orderId);
        if (order == null) {
            System.out.println("Order Not Found! ID: " + orderId);
            return;
        }

        System.out.println("Order ID: " + order.getOrderId() + ", Customer ID: " + order.getCustomerId() + ", Products: " + order.getProductIds() +
                ", Status: " + order.getStatus());
    }


    public void getAllOrders() {
        List<OrderEntity> orders = orderDao.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }

        System.out.println("All Orders:");
        for (OrderEntity order : orders) {
            System.out.println("Order ID: " + order.getOrderId() + ", Customer ID: " + order.getCustomerId() + ", Products: " + order.getProductIds() +
                    ", Status: " + order.getStatus());
        }
    }
}
