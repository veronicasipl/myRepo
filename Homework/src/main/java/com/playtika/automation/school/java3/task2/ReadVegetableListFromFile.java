package com.playtika.automation.school.java3.task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.playtika.automation.school.java2.task1.vegetable.Vegetable;
import com.playtika.automation.school.java3.task1.exception.IngredientDataIsInvalidException;

public class ReadVegetableListFromFile {

    public static ArrayList<Vegetable> readListFromFile() throws IngredientDataIsInvalidException {
        try (FileInputStream fileInputStream = new FileInputStream(new File("myRepo/Homework/target/listOfVeg.txt"))) {
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            ArrayList<Vegetable> listOfVeg = (ArrayList<Vegetable>) ois.readObject();
            ois.close();
            readTextFile();
            System.out.println(listOfVeg);
            return listOfVeg;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File not found!");
        }
        return null;
    }

    public static void readTextFile() {
        try (FileInputStream fis = new FileInputStream(new File("myRepo/Homework/target/list.txt"))) {
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            String aLine;
            ArrayList<String> listOfVeg = new ArrayList<>();
            int i = 0;
            while ((aLine = in.readLine()) != null) {
                Pattern pattern = Pattern.compile("[ ]");
                String[] words = pattern.split(aLine);
                String regexp = "(?<=(\\D|^))[1-9]\\d*";
                boolean result = words[2].matches(regexp);
                if (result) {
                    System.out.println("Calories validation passed.");
                    listOfVeg.add(aLine);
                } else {
                    System.out.println("Calories validation failed.");
                }
                System.out.println(aLine);
            }
            in.close();
            System.out.println(listOfVeg);
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }
}