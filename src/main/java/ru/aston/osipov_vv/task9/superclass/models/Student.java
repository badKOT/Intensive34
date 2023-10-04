package ru.aston.osipov_vv.task9.superclass.models;

import jakarta.persistence.Entity;

@Entity
public class Student extends Person {
    private int grade;

    public Student() {
    }

    public Student(int personId, String name, int grade) {
        super(personId, name);
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
