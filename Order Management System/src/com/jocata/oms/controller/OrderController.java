package com.jocata.oms.controller;

import com.jocata.oms.Bean.OrderBean;
import com.jocata.oms.service.OrderService;
import com.jocata.oms.service.impl.OrderServiceImpl;

import java.util.List;

public class OrderController {
    OrderService orderService=new OrderServiceImpl();
    public Object createOrder(OrderBean orderBean){
        orderService.createOrder(orderBean);
        return null;
    }
    public OrderBean getOrderById(int orderId){
        orderService.getOrderById(orderId);
        return null;
    }
    public void getAllOrders(){
        orderService.getAllOrders();
        return;

    }
}
