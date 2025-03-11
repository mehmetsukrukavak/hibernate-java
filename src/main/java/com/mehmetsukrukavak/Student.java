package com.mehmetsukrukavak;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {

    @Id
    private int rollNo;
    private String sName;
    private int sAge;

    private School school;

    @OneToOne
    private Laptop laptop;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Lesson> lessons;

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }



    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                ", school=" + school +
                ", laptop=" + laptop +
             //   ", lessons=" + lessons +
                '}';
    }
}
