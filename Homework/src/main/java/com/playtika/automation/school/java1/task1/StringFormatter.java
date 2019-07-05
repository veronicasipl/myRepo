package com.playtika.automation.school.java1.task1;

import java.util.Scanner;
import java.lang.StringBuilder;

public class StringFormatter {

    private static final String ASTERISK = "*";
    private static final String SPACE = " ";
    private static Scanner inputReader;

    public static void main(String[] args) {
        inputReader = new Scanner(System.in);
        System.out.print("Enter sentence:\n");
        String inputStr = inputReader.nextLine();
        String outputStr;
        //-------- task 1.1 -----------
        print(getReverseString(inputStr));
        //-------- task 1.2 -----------
        printWordsFromString(inputStr);
        //-------- task 1.3 -----------
        print(replaceSpacesToAsterisk(inputStr));
        //-------- task 1.4 -----------
        print(inputStr.toUpperCase());
        //--------- task 1.5 ----------
        System.out.print("Enter first index:\n");
        int firstIndex = inputReader.nextInt();
        System.out.print("Enter second index:\n");
        int secondIndex = inputReader.nextInt();
        outputStr = getSubstring(firstIndex, secondIndex, inputStr);
        print(outputStr);
        inputReader.close();
    }

    private static String getReverseString(String inputString) {
        StringBuilder stringBuilder = new StringBuilder(inputString);
        return stringBuilder.reverse().toString();
    }

    private static void printWordsFromString(String inputString) {
        String[] words = inputString.split("\\s+");
        for (String word : words) {
            System.out.println(word);
        }
    }

    private static String replaceSpacesToAsterisk(String inputString) {
        return inputString.replace(SPACE, ASTERISK);
    }

    private static String getSubstring(int firstIndex, int secondIndex, String inputString) {
        return inputString.substring(firstIndex - 1, secondIndex);
    }

    private static void print(String inputString) {
        System.out.println(inputString);
    }
}