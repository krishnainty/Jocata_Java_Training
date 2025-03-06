package com.jocata.OrderManagementSystem.service.impl;

import com.jocata.OrderManagementSystem.bean.CustomerBean;
import com.jocata.OrderManagementSystem.bean.OrderBean;
import com.jocata.OrderManagementSystem.bean.ProductBean;
import com.jocata.OrderManagementSystem.dao.OrderDao;
import com.jocata.OrderManagementSystem.entity.CustomerEntity;
import com.jocata.OrderManagementSystem.entity.OrderEntity;
import com.jocata.OrderManagementSystem.entity.ProductEntity;
import com.jocata.OrderManagementSystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public Object createOrder(OrderBean orderBean) {
        OrderEntity orderEntity=new OrderEntity();

        orderEntity.setOrderDate(orderBean.getOrderDate());
        orderEntity.setOrderTotal(orderBean.getOrderTotal());
        orderEntity.setStatus(orderBean.getStatus());


        CustomerBean customerBean = orderBean.getCustomerId();
        if (customerBean != null) {
            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setCustomerId(customerBean.getCustomerId());
            customerEntity.setName(customerBean.getName());
            customerEntity.setEmail(customerBean.getEmail());
            customerEntity.setAddress(customerBean.getAddress());
            orderEntity.setCustomerId(customerEntity);
        }


        List<ProductEntity> productEntities = new ArrayList<>();
        if (orderBean.getProductIds() != null) {
            for (ProductBean productBean : orderBean.getProductIds()) {
                ProductEntity productEntity = new ProductEntity();
                productEntity.setProductId(productBean.getProductId());
                productEntity.setProductName(productBean.getProductName());
                productEntity.setPrice(productBean.getPrice());
                productEntity.setStock(productBean.getStock());
                productEntities.add(productEntity);
            }
        }

        orderEntity.setProductIds(productEntities);
        System.out.println(orderEntity.getCustomerId().getCustomerId());
        return orderDao.createOrder(orderEntity);
    }

    @Override
    public Object getAllOrders() {
        List<OrderEntity>li= orderDao.getAllOrders();


        for (OrderEntity order : li) {
            printOrder(order);


        }
        return "Success";
    }

    @Override
    public Object getOrderById(int orderId) {
        OrderEntity order=orderDao.getOrderById(orderId);
        printOrder(order);
        return null;
    }

    @Override
    public Object deleteOrder(int orderId) {
       return orderDao.deleteOrder(orderId);

    }

    public void printOrder(OrderEntity order){
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Order Date: " + order.getOrderDate());
        System.out.println("Order Total: " + order.getOrderTotal());
        System.out.println("Status: " + order.getStatus());

        if (order.getCustomerId() != null) {
            CustomerEntity customer = order.getCustomerId();
            System.out.println("Customer ID: " + customer.getCustomerId());
            System.out.println("Customer Name: " + customer.getName());
            System.out.println("Customer Email: " + customer.getEmail());
            System.out.println("Customer Address: " + customer.getAddress());
        } else {
            System.out.println("No Customer Info Available");
        }

        if (order.getProductIds() != null && !order.getProductIds().isEmpty()) {
            System.out.println("Products:");
            for (ProductEntity product : order.getProductIds()) {
                System.out.println("  Product ID: " + product.getProductId());
                System.out.println("  Product Name: " + product.getProductName());
                System.out.println("  Price: " + product.getPrice());
                System.out.println("  Stock: " + product.getStock());

            }
        } else {
            System.out.println("No Products in Order");
        }
    }
}
