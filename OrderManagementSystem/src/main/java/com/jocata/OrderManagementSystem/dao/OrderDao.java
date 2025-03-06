package com.jocata.OrderManagementSystem.dao;

import com.jocata.OrderManagementSystem.entity.OrderEntity;

import java.util.List;

public interface OrderDao {
    List<OrderEntity> getAllOrders() ;

    Object createOrder(OrderEntity orderEntity);

    OrderEntity getOrderById(int orderId);

    Object deleteOrder(int orderId);
}
