package com.jocata.oms.service;

import com.jocata.oms.Bean.OrderBean;

import java.util.List;

public interface OrderService {
    Object createOrder(OrderBean orderBeans);
    OrderBean getOrderById(int orderId);
    void getAllOrders();
}
