package ru.aston.osipov_vv.task9.single_table.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("student")
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
