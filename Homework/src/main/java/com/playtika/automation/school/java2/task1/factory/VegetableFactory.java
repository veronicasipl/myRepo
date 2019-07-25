package com.playtika.automation.school.java2.task1.factory;

import com.playtika.automation.school.java2.task1.constant.VegetableType;
import com.playtika.automation.school.java2.task1.vegetable.Carrot;
import com.playtika.automation.school.java2.task1.vegetable.Onion;
import com.playtika.automation.school.java2.task1.vegetable.Potato;
import com.playtika.automation.school.java2.task1.vegetable.Vegetable;

public class VegetableFactory {

    public static Vegetable getVegetable(VegetableType type, String name, int weight, int calories, int amount, int farina) {
        Vegetable toReturn;
        switch (type) {
            case CARROT:
                toReturn = new Carrot(name, weight, calories, amount);
                break;
            case ONION:
                toReturn = new Onion(name, weight, calories, amount);
                break;
            case POTATO:
                toReturn = new Potato(name, weight, calories, amount, farina);
                break;
            default:
                throw new IllegalArgumentException("Unknown vegetable type:" + type);
        }
        return toReturn;
    }
}