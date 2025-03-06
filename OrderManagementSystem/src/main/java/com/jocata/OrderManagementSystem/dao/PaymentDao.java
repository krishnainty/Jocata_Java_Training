package com.jocata.OrderManagementSystem.dao;

import com.jocata.OrderManagementSystem.entity.PaymentEntity;

import java.util.List;

public interface PaymentDao {
    void savePayment(PaymentEntity payment);
    PaymentEntity getPaymentById(int paymentId);
    PaymentEntity getPaymentByOrderId(int orderId);
    List<PaymentEntity> getAllPayments();
}
