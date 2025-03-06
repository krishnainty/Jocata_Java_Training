package com.jocata.oms.service.impl;

import com.jocata.oms.Bean.PaymentBean;
import com.jocata.oms.dao.PaymentDao;
import com.jocata.oms.dao.impl.PaymentDaoImpl;
import com.jocata.oms.entity.PaymentEntity;
import com.jocata.oms.service.PaymentService;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    PaymentDao paymentDao=new PaymentDaoImpl();
    @Override
    public PaymentBean processPayment(PaymentBean paymentBean) {
        PaymentEntity paymentEntity=new PaymentEntity(paymentBean.getPaymentId(),paymentBean.getOrderId(),paymentBean.getAmount(),paymentBean.getStatus());
        paymentDao.processPayment(paymentEntity);
        return null;
    }

    @Override
    public PaymentBean getPaymentByOrderId(int orderId) {
        PaymentEntity payment=paymentDao.getPaymentByOrderId(orderId);
        System.out.println("Payment ID: " + payment.getPaymentId() + ", Order ID: " + payment.getOrderId() + ", Amount: " + payment.getAmount() +
                ", Status: " + payment.getStatus());
        return null;
    }

    @Override
    public void getAllPayments() {
        List<PaymentEntity> payments = paymentDao.getAllPayments();

        if (payments.isEmpty()) {
            System.out.println("No payments found.");
            return;
        }

        System.out.println("All Payments:");
        for (PaymentEntity payment : payments) {
            System.out.println("Payment ID: " + payment.getPaymentId() + ", Order ID: " + payment.getOrderId() + ", Amount: " + payment.getAmount() +
                    ", Status: " + payment.getStatus());
        }



    }
}
