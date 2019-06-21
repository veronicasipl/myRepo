package com.playtika.automation.school.java1.task4;

import java.util.Arrays;
import java.util.Scanner;

public class Marathon {

    private static String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel",
            "Neda", "Aaron", "Kate"};
    private static int[] results = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
    private static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        sortResults();
        printAllResults();
        printResult(1);
        printResult(2);
        findByPlace();
        input.close();
    }

    private static String getNameAndResult(int place) {
        return String.format("%s - %d", names[place - 1], results[place - 1]);
    }

    private static void sortResults() {
        int namesLength = names.length;
        for (int k = 0; k < namesLength; k++) {
            for (int j = 0; j < namesLength - 1; j++) {
                if (results[j] > results[j + 1]) {
                    int temp = results[j];
                    results[j] = results[j + 1];
                    results[j + 1] = temp;
                    String temp2 = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp2;
                }
            }
        }

    }

    private static void printAllResults() {
        int namesLength = names.length;
        for (int i = 0; i < namesLength; i++) {
            String nameAndResult = String.format("%s - %d", names[i], results[i]);
            System.out.println(nameAndResult);
        }
    }

    private static void findByPlace() {
        System.out.println("Input place of runner\n");
        int inputPlace = input.nextInt();
        printResult(inputPlace);
    }

    private static void printResult(int place) {
        System.out.println(place + " place");
        System.out.println(getNameAndResult(place));
    }
}