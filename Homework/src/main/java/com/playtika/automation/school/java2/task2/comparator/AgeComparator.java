package com.playtika.automation.school.java2.task2.comparator;

import java.util.Comparator;

import com.playtika.automation.school.java2.task2.Student;

public class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getStudentAge() - o2.getStudentAge();
    }
}