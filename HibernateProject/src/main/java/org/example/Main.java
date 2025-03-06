package org.example;

import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        User user=new User("Ravi");
        User user1=new User("Mohan");

        session.persist(user);

       // user.setUserName("hari");
        session.persist(user1);
        transaction.commit();
        sessionFactory.close();
    }
}