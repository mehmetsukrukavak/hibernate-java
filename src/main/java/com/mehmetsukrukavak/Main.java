package com.mehmetsukrukavak;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setsName("Gustov");
        s1.setsAge(47);
        s1.setRollNo(107);

//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(com.mehmetsukrukavak.Student.class);
//        cfg.configure();

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.mehmetsukrukavak.Student.class)
                .configure()
                .buildSessionFactory(); //cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.persist(s1);

        tx.commit();
        session.close();
        sf.close();
        System.out.println(s1);
    }
}