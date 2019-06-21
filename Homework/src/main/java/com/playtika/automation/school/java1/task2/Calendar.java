package com.playtika.automation.school.java1.task2;

import java.util.Scanner;
import java.time.DayOfWeek;

public class Calendar {

    private static Scanner inputReader;

    public static void main(String[] args) {
        inputReader = new Scanner(System.in);
        System.out.print("Enter number of day (from 1 to 7):");
        int inputInt = inputReader.nextInt();
        String day = getDayByInbex(inputInt);
        System.out.println(day);
        inputReader.close();
    }

    private static String getDayByInbex(int inputInt) {
        DayOfWeek dayOfWeek = DayOfWeek.of(inputInt);
        return dayOfWeek.name();
    }
}