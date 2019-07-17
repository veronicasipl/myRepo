package com.playtika.automation.school.java3.exceptionsUsage;

import java.util.ArrayList;

import com.playtika.automation.school.java2.common.Helper;
import com.playtika.automation.school.java2.task1.Chef;
import com.playtika.automation.school.java2.task1.Salad;
import com.playtika.automation.school.java2.task1.constant.VegetableType;
import com.playtika.automation.school.java2.task1.factory.VegetableFactory;
import com.playtika.automation.school.java2.task1.vegetable.Vegetable;
import com.playtika.automation.school.java3.task1.exception.IngredientDataIsInvalidException;
import com.playtika.automation.school.java3.task1.exception.IngredientsNotFoundException;
import com.playtika.automation.school.java3.task1.exception.SaladBowlIsFullException;

public class IngredientExceptionSample {
    public static void main(String[] args) {
        checkInvalidIngredentDataException();
        checkIngredientsNotFoundException();
        checkSaladBowlIsFullException();
        checkNullPointerException();
    }

    private static void checkInvalidIngredentDataException() {
        try {
            ArrayList<Vegetable> vegetablesList = createInvalidVegetablesList();
            System.out.println(vegetablesList);
        } catch (IngredientDataIsInvalidException e) {
            e.printStackTrace();
        }
    }

    private static void checkIngredientsNotFoundException() {
        try {
            Chef chef = new Chef();
            ArrayList<Vegetable> vegetablesList = new ArrayList<>();
            Salad salad = chef.makeAndGetSalad(vegetablesList);
            System.out.println(salad.getSaladInfo());
        } catch (IngredientsNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void checkSaladBowlIsFullException() {
        try {
            Salad salad = new Salad();
            ArrayList<Vegetable> listOfVegetables = createBigVegetablesList();
            for (Vegetable vegetable : listOfVegetables) {
                salad.addComponent(vegetable);
            }
        } catch (SaladBowlIsFullException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Vegetable> createInvalidVegetablesList() throws IngredientDataIsInvalidException {
        Vegetable carrot = VegetableFactory.getVegetable(VegetableType.CARROT, "Carrot", 0, 15, 1, 0);
        ArrayList<Vegetable> vegetablesList = new ArrayList<>();
        vegetablesList.add(carrot);
        if (Helper.validateList(vegetablesList)) {
            return vegetablesList;
        } else {
            throw new IngredientDataIsInvalidException("Check ingredients data!");
        }
    }

    private static ArrayList<Vegetable> createBigVegetablesList() {
        Vegetable carrot = VegetableFactory.getVegetable(VegetableType.CARROT, "Carrot", 0, 15, 1, 0);
        ArrayList<Vegetable> vegetablesList = new ArrayList<>();
        vegetablesList.add(carrot);
        vegetablesList.add(carrot);
        vegetablesList.add(carrot);
        vegetablesList.add(carrot);
        vegetablesList.add(carrot);
        return vegetablesList;
    }

    private static void checkNullPointerException() throws NullPointerException {
        try {
            Vegetable vegetable = null;
            System.out.println(vegetable.getAmount());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}