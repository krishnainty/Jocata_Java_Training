package com.jocata.OrderManagementSystem.dao.impl;

import com.jocata.OrderManagementSystem.dao.PaymentDao;
import com.jocata.OrderManagementSystem.entity.PaymentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentDaoImpl implements PaymentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void savePayment(PaymentEntity payment) {
        entityManager.persist(payment);
        System.out.println("Payment saved with ID: " + payment.getPaymentId());
    }

    @Override
    public PaymentEntity getPaymentById(int paymentId) {
        PaymentEntity payment = entityManager.find(PaymentEntity.class, paymentId);
        if (payment != null) {
            System.out.println("Payment found with ID: " + paymentId);
        } else {
            System.out.println("Payment not found with ID: " + paymentId);
        }
        return payment;
    }

    @Override
    public PaymentEntity getPaymentByOrderId(int orderId) {
        try {
            return entityManager.createQuery(
                            "SELECT p FROM PaymentEntity p WHERE p.order.orderId = :orderId", PaymentEntity.class)
                    .setParameter("orderId", orderId)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("Payment not found for Order ID: " + orderId);
            return null;
        }
    }

    @Override
    public List<PaymentEntity> getAllPayments() {
        List<PaymentEntity> payments = entityManager.createQuery("SELECT p FROM PaymentEntity p", PaymentEntity.class)
                .getResultList();

        System.out.println("Total Payments Retrieved: " + payments.size());
        return payments;
    }
}
