package ru.aston.osipov_vv.task9.joined.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "teacher_id")
public class Teacher extends Person {
    private String subject;

    public Teacher() {
    }

    public Teacher(int personId, String name, String subject) {
        super(personId, name);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
