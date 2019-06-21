package com.playtika.automation.school.java3.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.playtika.automation.school.java2.common.Helper;
import com.playtika.automation.school.java2.task1.vegetable.Vegetable;
import com.playtika.automation.school.java3.task1.exception.IngredientDataIsInvalidException;

public class WriteVegetableListToFile {

    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File("./Homework/target/listOfVeg.txt"))) {
            ArrayList<Vegetable> vegetablesList = Helper.createVegetablesList();
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(vegetablesList);
            oos.close();
            System.out.println("File written successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        writeTextFile();
    }

    public static void writeTextFile() {
        try (PrintWriter outputStream = new PrintWriter(new FileOutputStream("./Homework/target/list.txt"))) {
            ArrayList<Vegetable> vegetablesList = Helper.createVegetablesList();
            for (Vegetable item : vegetablesList) {
                outputStream.println(item.getName() + ' ' + item.getWeight() + ' ' + item.getCalories() + ' ' + item.getAmount());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File list.txt not found.");
        } catch (IngredientDataIsInvalidException e) {
            System.out.println("Error creating vegetables list. Invalid data");
        }
    }
}