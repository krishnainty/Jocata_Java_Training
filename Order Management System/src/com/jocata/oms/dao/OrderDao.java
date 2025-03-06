package com.jocata.oms.dao;

import com.jocata.oms.entity.OrderEntity;

import java.util.List;

public interface OrderDao {
    Object createOrder(OrderEntity orderEntity);

    OrderEntity getOrderById(int orderId);

    List<OrderEntity> getAllOrders();
    List<OrderEntity> getAllOrders(int customerId);

    void updateOrder(OrderEntity orderEntity);

    void deleteOrder(int orderId);
}
