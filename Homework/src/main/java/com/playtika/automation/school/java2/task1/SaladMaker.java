package com.playtika.automation.school.java2.task1;

import java.util.ArrayList;

import com.playtika.automation.school.java2.task1.comparator.AmountComparator;
import com.playtika.automation.school.java2.task1.vegetable.Vegetable;
import com.playtika.automation.school.java3.task1.exception.IngredientDataIsInvalidException;
import com.playtika.automation.school.java3.task1.exception.IngredientsNotFoundException;
import com.playtika.automation.school.java3.task2.ReadVegetableListFromFile;

public class SaladMaker {

    public static ArrayList<Vegetable> vegetablesList;

    public static void main(String[] args) {
        try {
            vegetablesList = ReadVegetableListFromFile.readListFromFile();
        } catch (IngredientDataIsInvalidException e) {
            System.out.println(e);
        }

        sortVegetablesByAmount(vegetablesList);
        printVegetablesList(vegetablesList);
        ArrayList<Vegetable> vegetablesListByRange = getVegetablesListByRange(vegetablesList);

        Chef chef = new Chef();
        try {
            Salad salad = chef.makeAndGetSalad(vegetablesList);
            printSaladInfo(salad);
        } catch (IngredientsNotFoundException e) {
            System.out.println("Vegetables list is empty!");
        }
    }

    private static void sortVegetablesByAmount(ArrayList<Vegetable> vegetablesList) {
        vegetablesList.sort(new AmountComparator());
    }

    private static void printVegetablesList(ArrayList<Vegetable> vegetablesList) {
        System.out.println("List of Vegetables:");
        for (Vegetable item : vegetablesList) {
            System.out.println(item);
        }
    }

    private static ArrayList<Vegetable> getVegetablesListByRange(ArrayList<Vegetable> vegetablesList) {
        ArrayList<Vegetable> tempList = new ArrayList();
        for (Vegetable item : vegetablesList) {
            if (item.getCalories() > 2 && item.getCalories() < 99) {
                tempList.add(item);
            }
        }
        return tempList;
    }

    private static void printSaladInfo(Salad salad) {
        System.out.println("Salad contains:");
        System.out.println(salad.getSaladInfo());
        System.out.println("Total amount of calories: " + salad.getTotalCalories());
    }
}