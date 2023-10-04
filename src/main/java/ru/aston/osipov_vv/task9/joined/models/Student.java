package ru.aston.osipov_vv.task9.joined.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "student_id")
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
