package com.jocata.OrderManagementSystem.service;

import com.jocata.OrderManagementSystem.bean.PaymentBean;

import java.util.List;

public interface PaymentService {
    Object processPayment(int orderId,String status);

    Object getAllPayments();

   Object getPaymentById(int paymentId);

   Object getPaymentByOrderId(int orderId);
}
