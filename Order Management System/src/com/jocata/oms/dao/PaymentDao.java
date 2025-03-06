package com.jocata.oms.dao;

import com.jocata.oms.entity.PaymentEntity;

import java.util.List;

public interface PaymentDao {
    PaymentEntity processPayment(PaymentEntity payment);
    PaymentEntity getPaymentByOrderId(int orderId);
    List<PaymentEntity> getAllPayments();
    
}
