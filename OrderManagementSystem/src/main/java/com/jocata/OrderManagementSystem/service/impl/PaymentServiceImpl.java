package com.jocata.OrderManagementSystem.service.impl;

import com.jocata.OrderManagementSystem.dao.OrderDao;
import com.jocata.OrderManagementSystem.dao.PaymentDao;
import com.jocata.OrderManagementSystem.entity.OrderEntity;
import com.jocata.OrderManagementSystem.entity.PaymentEntity;
import com.jocata.OrderManagementSystem.service.PaymentService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDao paymentDao;
    private final OrderDao orderDao;

    public PaymentServiceImpl(PaymentDao paymentDao, OrderDao orderDao) {
        this.paymentDao = paymentDao;
        this.orderDao = orderDao;
    }

    @Transactional
    @Override
    public Object processPayment(int orderId, String status) {
        OrderEntity order = orderDao.getOrderById(orderId);
        if (order != null) {
            double amount = order.getOrderTotal();
            PaymentEntity payment = new PaymentEntity();
            payment.setOrder(order);
            payment.setAmount(amount);
            payment.setPaymentDate(new Date(System.currentTimeMillis()));
            payment.setPaymentStatus(status);
            paymentDao.savePayment(payment);


            System.out.println("Payment Processed for Order ID: " + orderId);
            System.out.println("Amount: " + amount);
            System.out.println("Payment Status: " + status);
            System.out.println("Payment Date: " + payment.getPaymentDate());

            return "success";
        } else {
            System.out.println("Order not found with ID: " + orderId);
            return "failure: Order not found";
        }
    }

    @Transactional
    public Object savePayment(PaymentEntity payment) {

        paymentDao.savePayment(payment);
        System.out.println("Payment saved with ID: " + payment.getPaymentId());
        return "success";
    }

    @Override
    public Object getAllPayments() {

        List<PaymentEntity> payments = paymentDao.getAllPayments();
        System.out.println("All Payments:");
        for (PaymentEntity payment : payments) {
            System.out.println("Payment ID: " + payment.getPaymentId());
            System.out.println("Order ID: " + payment.getOrder().getOrderId());
            System.out.println("Amount: " + payment.getAmount());
            System.out.println("Status: " + payment.getPaymentStatus());
            System.out.println("Date: " + payment.getPaymentDate());
        }
        return "success";
    }

    @Override
    public Object getPaymentById(int paymentId) {
        PaymentEntity payment = paymentDao.getPaymentById(paymentId);
        if (payment != null) {
            System.out.println("Payment Details:");
            System.out.println("Payment ID: " + payment.getPaymentId());
            System.out.println("Order ID: " + payment.getOrder().getOrderId());
            System.out.println("Amount: " + payment.getAmount());
            System.out.println("Status: " + payment.getPaymentStatus());
            System.out.println("Date: " + payment.getPaymentDate());
            return "success";
        } else {
            System.out.println("Payment not found with ID: " + paymentId);
            return "failure: Payment not found";
        }
    }

    @Override
    public Object getPaymentByOrderId(int orderId) {
        return paymentDao.getPaymentByOrderId(orderId);
    }
}