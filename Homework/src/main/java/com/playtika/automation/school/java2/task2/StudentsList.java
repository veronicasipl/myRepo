package com.playtika.automation.school.java2.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.playtika.automation.school.java2.common.Helper;
import com.playtika.automation.school.java2.task2.comparator.AgeComparator;

public class StudentsList {

    public static final char LETTER = 'D';
    public static ArrayList<Student> students;

    public static void main(String[] args) {
        students = Helper.createStudentsList();
        sortStudentsByAge(students);
        printMiddleAge();
        printAllStudents();
        printFilteredListByLetterD();
        getMapFromList(students);
        getSelectionFromMap(getMapFromList(students));
    }

    private static void sortStudentsByAge(ArrayList<Student> students) {
        students.sort(new AgeComparator());
    }

    private static void printAllStudents() {
        System.out.println("List of Students:");
        for (Student item : students) {
            System.out.println(item);
        }
    }

    private static void printFilteredListByLetterD() {
        System.out.println("List of students with last name starting from 'D':");
        System.out.println(filterListByLetterD(students, LETTER));
    }

    private static ArrayList<Student> filterListByLetterD(ArrayList<Student> students, char letter) {
        ArrayList<Student> tempList = new ArrayList();
        for (Student item : students) {
            if (item.getStudentLastName().charAt(0) == letter) {
                tempList.add(item);
            }
        }
        return tempList;
    }

    private static void printMiddleAge() {
        System.out.print("Middle age of students: ");
        System.out.println(getMiddleAge(students));
    }

    private static double getMiddleAge(ArrayList<Student> students) {
        double middleAge = 0;
        for (Student item : students) {
            middleAge += item.getStudentAge();
        }
        middleAge = middleAge / students.size();
        return middleAge;
    }

    private static HashMap<Integer, Student> getMapFromList(ArrayList<Student> students) {
        HashMap<Integer, Student> map = new HashMap<>();
        for (Student item : students) {
            map.put(item.getStudentId(), item);
        }
        return map;
    }

    private static HashMap<Integer, Student> getSelectionFromMap(HashMap<Integer, Student> map) {
        HashMap<Integer, Student> resultMap = new HashMap<Integer, Student>();
        for (Map.Entry<Integer, Student> pair : map.entrySet()) {
            if (pair.getValue().getStudentId() > 5) {
                resultMap.put(pair.getKey(), pair.getValue());
            }
        }
        return resultMap;
    }
}