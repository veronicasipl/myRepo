package com.playtika.automation.school.java2.task3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;

import com.playtika.automation.school.java2.task2.Student;
import com.playtika.automation.school.java2.common.Helper;

public class StudentsList {

    public static void main(String[] args) {
        List<Student> students = Helper.createStudentsList();
        sortStudentsByAge(students);
        filterListByLetterD(students);
        countMiddleAge(students);
        Map<Integer, Student> map = getMapFromList(students);
        filterMap(map);
    }

    private static void sortStudentsByAge(List<Student> students) {
        System.out.println("Sorted students list by age: ");
        List<Student> sortedList = students.stream().sorted(Comparator.comparingInt(Student::getStudentAge)).collect(Collectors.toList());
        sortedList.forEach(System.out::println);
    }

    private static void filterListByLetterD(List<Student> students) {
        System.out.println("Filtered stream by letter of surname (D): ");
        List<Student> filterListByLetter = students.stream().filter(student -> student.getStudentLastName().charAt(0) == 'D').collect(Collectors.toList());
        filterListByLetter.forEach(System.out::println);
    }

    private static void countMiddleAge(List<Student> students) {
        System.out.print("Middle age is: ");
        int result = students.stream().mapToInt(Student::getStudentAge).sum() / students.size();
        System.out.println(result);
    }

    private static Map<Integer, Student> getMapFromList(List<Student> students) {
        Map<Integer, Student> map = students.stream().collect(Collectors.toMap(Student::getStudentId, Function.identity()));
        return map;
    }

    private static Map<Integer, Student> filterMap(Map<Integer, Student> map) {
        System.out.println("Filtered map by index (starting from 6th): ");
        Map<Integer, Student> result = map.entrySet().stream()
                                          .filter(student -> student.getKey() > 5).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return (result);
    }
}