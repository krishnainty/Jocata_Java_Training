package com.jocata.oms.dao.impl;

import com.jocata.oms.controller.OrderManager;
import com.jocata.oms.dao.PaymentDao;
import com.jocata.oms.entity.PaymentEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PaymentDaoImpl implements PaymentDao {
    private static final String FILE_NAME = "payments.ser";
    private void saveToFile(List<PaymentEntity> payments) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(payments);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private List<PaymentEntity> loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<PaymentEntity>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public PaymentEntity processPayment(PaymentEntity payment) {
        Random rand = new Random();
        List<PaymentEntity> payments = loadFromFile();
       int paymentId= rand.nextInt(10000);
        payment.setPaymentId(paymentId);

        payments.add(payment);
        saveToFile(payments);
        System.out.println("Payment Successfull PaymentId: "+payment.getPaymentId());
        OrderManager orderManager=new OrderManager();
        orderManager.processOrder(payment.getOrderId());
        return payment;
    }

    @Override
    public PaymentEntity getPaymentByOrderId(int orderId) {
        return loadFromFile().stream()
                .filter(p -> p.getOrderId() == orderId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<PaymentEntity> getAllPayments() {
        return loadFromFile();
    }
}
