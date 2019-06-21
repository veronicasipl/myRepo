package com.playtika.automation.school.java2.task1;

import java.util.ArrayList;

import com.playtika.automation.school.java2.task1.vegetable.Vegetable;
import com.playtika.automation.school.java3.task1.exception.SaladBowlIsFullException;

public class Salad {

    private ArrayList<Vegetable> saladComponents = new ArrayList<>();
    private static final int INGREDIENTS_AMOUNT = 4;
    private int totalCal;

    public Salad() {
    }

    public ArrayList<Vegetable> getSaladInfo() {
        return saladComponents;
    }

    public int getTotalCalories() {
        return totalCal;
    }

    public void addComponent(Vegetable vegetable) throws SaladBowlIsFullException {
        if (saladComponents.size() < INGREDIENTS_AMOUNT) {
            saladComponents.add(vegetable);
            totalCal += vegetable.getTotalCalories();
        } else {
            throw new SaladBowlIsFullException();
        }
    }
}