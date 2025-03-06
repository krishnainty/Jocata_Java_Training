package com.jocata.OrderManagementSystem.controller;

import com.jocata.OrderManagementSystem.bean.PaymentBean;
import com.jocata.OrderManagementSystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oms/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping("/process")
    public Object processPayment(@RequestParam int orderId,String status) {
        try {
            paymentService.processPayment(orderId,status);
            return "Payment processed successfully";
        } catch (Exception e) {
            return "Error processing payment: " + e.getMessage();
        }
    }


    @GetMapping("/all")
    public Object getAllPayments() {
        return paymentService.getAllPayments();
    }


    @GetMapping("/{paymentId}")
    public Object getPaymentById(@PathVariable int paymentId) {
        return paymentService.getPaymentById(paymentId);
    }


    @GetMapping("/order/{orderId}")
    public Object getPaymentByOrderId(@PathVariable int orderId) {
        return paymentService.getPaymentByOrderId(orderId);
    }
}
