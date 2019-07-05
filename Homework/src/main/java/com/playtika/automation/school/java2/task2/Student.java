package com.playtika.automation.school.java2.task2;

public class Student {

    private final int id;
    private final String name;
    private final String lastName;
    private final int age;

    public Student(int id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Integer getStudentId() {
        return id;
    }

    public String getStudentLastName() {
        return lastName;
    }

    public Integer getStudentAge() {
        return age;
    }

    public String toString() {
        return String.format("%d - Name:%s, Last Name:%s, Age:%d", id, name, lastName, age);
    }
}