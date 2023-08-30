package ru.aston.osipov_vv.task1.entities;

public class User implements Comparable<User> {
    private String firstName;
    private String lastName;
    private int age;
    private boolean constantUser;

    public User(String firstName, String lastName, int age, boolean constantUser) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.constantUser = constantUser;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isConstantUser() {
        return constantUser;
    }

    public void setConstantUser(boolean constantUser) {
        this.constantUser = constantUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(User o) {
        return lastName.compareTo(o.lastName);
    }
}
