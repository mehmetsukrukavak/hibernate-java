package com.mehmetsukrukavak;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setsName("jane");
        s1.setsAge(47);
        s1.setRollNo(101);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(com.mehmetsukrukavak.Student.class);
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(s1);

        tx.commit();
        System.out.println(s1);
    }
}