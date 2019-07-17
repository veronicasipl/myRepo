package com.playtika.automation.school.java3.task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.playtika.automation.school.java2.common.Helper;
import com.playtika.automation.school.java2.task1.vegetable.Vegetable;
import com.playtika.automation.school.java3.task1.exception.IngredientDataIsInvalidException;

public class WriteVegetableListToFile {

    public static final String REGEXP = "(\\D+)\\s(\\d+)\\s(\\d+)\\s(\\d+)";

    public static void main(String[] args) {
        writeTextFile();
        readTextFile();
    }

    public static void writeTextFile() {
        try (PrintWriter outputStream = new PrintWriter(new FileOutputStream("./Homework/target/list.txt"))) {
            ArrayList<Vegetable> vegetablesList = Helper.createVegetablesList();
            for (Vegetable item : vegetablesList) {
                outputStream.println(item.getName() + ' ' + item.getWeight() + ' ' + item.getCalories() + ' ' + item.getAmount());
            }
        } catch (FileNotFoundException | IngredientDataIsInvalidException e) {
            e.printStackTrace();
        }
        System.out.println("FILE IS WRITTEN SUCCESSFULLY");
    }

    public static void readTextFile() {
        System.out.println("READING FILE");
        try (FileInputStream fis = new FileInputStream(new File("./Homework/target/list.txt"))) {
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            String aLine;
            ArrayList<String> listOfVeg = new ArrayList<>();
            while ((aLine = in.readLine()) != null) {
                boolean result = aLine.matches(REGEXP);
                if (result) {
                    System.out.println("Valid record format");
                    listOfVeg.add(aLine);
                } else {
                    System.out.println("Invalid record format");
                }
                System.out.println(aLine);
            }
            System.out.println(listOfVeg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}