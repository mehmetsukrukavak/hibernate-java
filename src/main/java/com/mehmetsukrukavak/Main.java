package com.mehmetsukrukavak;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.mehmetsukrukavak.Student.class)
                .configure()
                .buildSessionFactory(); //cfg.buildSessionFactory();
        Session session = sf.openSession();

        Student s = save(session);
        s = session.get(Student.class, 110);
        //s1.setsAge(45);
        //update(session,s1);
        //delete(session,s);
        session.close();
        sf.close();
        System.out.println(s);
    }

    private static Student save(Session session) {
        Transaction tx = session.beginTransaction();

        Student s1 = new Student();
        s1.setsName("Mark");
        s1.setsAge(22);
        s1.setRollNo(110);

        School school = new School();
        school.setName("San Francisco School");
        school.setAddress("San Francisco");


        s1.setSchool(school);


        session.persist(s1);

        tx.commit();
        return s1;
    }

    private static Student update(Session session, Student s) {
        Transaction tx = session.beginTransaction();

        session.merge(s);

        tx.commit();
        return s;
    }

    private static void delete(Session session, Student s) {
        Transaction tx = session.beginTransaction();

        session.remove(s);

        tx.commit();

        System.out.println(s.getRollNo() + " has been deleted.");

    }
}