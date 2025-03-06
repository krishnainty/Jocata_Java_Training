package com.jocata.oms.service;

import com.jocata.oms.Bean.PaymentBean;

public interface PaymentService {
    PaymentBean processPayment(PaymentBean paymentBean);
    PaymentBean getPaymentByOrderId(int orderId);
    void getAllPayments();
}
