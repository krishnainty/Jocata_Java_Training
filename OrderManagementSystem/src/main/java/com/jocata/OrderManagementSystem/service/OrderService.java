package com.jocata.OrderManagementSystem.service;

import com.jocata.OrderManagementSystem.bean.OrderBean;

public interface OrderService {
    Object createOrder(OrderBean orderBean);

    Object getAllOrders();

    Object getOrderById(int orderId);

    Object deleteOrder(int orderId);
}
