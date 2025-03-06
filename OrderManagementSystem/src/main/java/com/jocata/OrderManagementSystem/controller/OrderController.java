package com.jocata.OrderManagementSystem.controller;

import com.jocata.OrderManagementSystem.bean.OrderBean;
import com.jocata.OrderManagementSystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oms/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/add")
    public Object createOrder(@RequestBody OrderBean orderBean){
        System.out.println(orderBean.getCustomerId().getCustomerId());
        return orderService.createOrder(orderBean);



    }
    @GetMapping("/getAll")
    public Object getAllOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping("getById/{orderId}")
    public Object getOrderById(@PathVariable int orderId){
        return orderService.getOrderById(orderId);
    }

    @DeleteMapping("/delete/{orderId}")
    public Object deleteOrder(@PathVariable int orderId){
        return orderService.deleteOrder(orderId);
    }
}
