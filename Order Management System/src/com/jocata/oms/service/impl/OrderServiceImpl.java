package com.jocata.oms.service.impl;

import com.jocata.oms.Bean.OrderBean;
import com.jocata.oms.dao.OrderDao;
import com.jocata.oms.dao.impl.OrderDaoImpl;
import com.jocata.oms.entity.OrderEntity;
import com.jocata.oms.service.OrderService;

import java.util.*;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public Object createOrder(OrderBean orderBean) {
        OrderEntity orderEntity = new OrderEntity(0, orderBean.getCustomerId(), orderBean.getProductIds(), orderBean.getStatus());
         orderDao.createOrder(orderEntity);
        return null;
    }

    @Override
    public OrderBean getOrderById(int orderId) {
        OrderEntity orderEntity = orderDao.getOrderById(orderId);
        if (orderEntity == null) {
            return null;
        }
        return null;
    }

    @Override
    public void getAllOrders() {
        List<OrderEntity> orderEntities = orderDao.getAllOrders();

        if (orderEntities.isEmpty()) {
            System.out.println("No orders available.");
            return;
        }

        System.out.println("All Orders:");
        for (OrderEntity entity : orderEntities) {
            System.out.println("Order ID: " + entity.getOrderId() + ", Customer ID: " + entity.getCustomerId() + ", Products: " + entity.getProductIds() +
                    ", Status: " + entity.getStatus());
        }
        return;
    }
}
