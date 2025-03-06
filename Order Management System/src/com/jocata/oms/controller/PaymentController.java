package com.jocata.oms.controller;

import com.jocata.oms.Bean.PaymentBean;
import com.jocata.oms.entity.PaymentEntity;
import com.jocata.oms.service.PaymentService;
import com.jocata.oms.service.impl.PaymentServiceImpl;

import java.util.List;

public class PaymentController {
    PaymentService paymentService=new PaymentServiceImpl();
    public PaymentBean processPayment(PaymentBean paymentBean){
        paymentService.processPayment(paymentBean);

                return null;
    }
    public PaymentBean getPaymentByOrderId(int orderId){
        paymentService.getPaymentByOrderId(orderId);
        return null;
    }
    public void getAllPayments(){
        paymentService.getAllPayments();
        return;
    }
}
