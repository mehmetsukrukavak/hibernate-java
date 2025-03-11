package com.mehmetsukrukavak;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.mehmetsukrukavak.Student.class)
                .addAnnotatedClass(com.mehmetsukrukavak.Lesson.class)
                .addAnnotatedClass(com.mehmetsukrukavak.Laptop.class)
                .addAnnotatedClass(com.mehmetsukrukavak.Teacher.class)
                .configure()
                .buildSessionFactory(); //cfg.buildSessionFactory();
        Session session = sf.openSession();


       Student s = null;
       //s = save(session);
      // s = session.get(Student.class, 101);

        int id=1;
        String brand = "Apple";

       List<Laptop> laptops = session.createQuery("from Laptop l where l.brand = ?1", Laptop.class)
              // .setParameter(1,id)
               .setParameter(1,brand)
               .getResultList();

        System.out.println(laptops);
        //s1.setsAge(45);
        //update(session,s1);
        //delete(session,s);
        session.close();
        sf.close();
      // System.out.println(s);
    }

    private static Student save(Session session) {
        Transaction tx = session.beginTransaction();

        Teacher t1 = new Teacher();
        t1.setId(3);
        t1.setName("Tim");
        t1.setAge(75);

        Teacher t2 = new Teacher();
        t2.setId(4);
        t2.setName("Jim");
        t2.setAge(72);

        Lesson l1 = new Lesson();
        l1.setId(103);
        l1.setName("Math");



        Lesson l2 = new Lesson();
        l2.setId(104);
        l2.setName("C# Fundamentals");


        Student s1 = new Student();
        s1.setsName("Olga");
        s1.setsAge(42);
        s1.setRollNo(102);
        s1.setLessons(Arrays.asList(l1,l2));

        School school = new School();
        school.setName("SF High School");
        school.setAddress("San Francisco");

        Laptop laptop = new Laptop();
        laptop.setLid(2);
        laptop.setBrand("Apple");
        laptop.setModel("Macbook Pro");
        laptop.setRam(18);


        session.persist(t1);
        session.persist(t2);

        l1.setTeachers(Arrays.asList(t1));
        l2.setTeachers(Arrays.asList(t2));

        l1.setStudent(s1);
        l2.setStudent(s1);

        session.persist(l1);
        session.persist(l2);

        s1.setLaptop(laptop);
        s1.setSchool(school);

        session.persist(laptop);
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