package com.playtika.automation.school.java2.task1;

import java.util.ArrayList;

import com.playtika.automation.school.java2.task1.vegetable.Vegetable;
import com.playtika.automation.school.java3.task1.exception.IngredientsNotFoundException;
import com.playtika.automation.school.java3.task1.exception.SaladBowlIsFullException;

public class Chef {

    public Chef() {
    }

    public Salad makeAndGetSalad(ArrayList<Vegetable> listOfVegetables) throws IngredientsNotFoundException {
        if (listOfVegetables.isEmpty()) {
            throw new IngredientsNotFoundException();
        }
        Salad salad = new Salad();
        for (Vegetable vegetable : listOfVegetables) {
            try {
                salad.addComponent(vegetable);
            } catch (SaladBowlIsFullException e) {
                System.out.println(e);
            }
        }
        return salad;
    }
}