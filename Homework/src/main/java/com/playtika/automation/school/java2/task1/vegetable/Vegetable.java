package com.playtika.automation.school.java2.task1.vegetable;

import java.io.Serializable;

public abstract class Vegetable implements Serializable {

    private final String name;
    private final int weight;
    private final int calories;
    private final int amount;

    public Vegetable(String name, int weight, int calories, int amount) {
        this.name = name;
        this.weight = weight;
        this.calories = calories;
        this.amount = amount;
    }

    public String toString() {
        return (weight + " gramms of " + name + " contains " + getTotalCalories() + " calories");
    }

    public String getName () {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getAmount() {
        return amount;
    }

    public int getWeight () {
        return weight;
    }

    public int getTotalCalories() {
        return calories * weight;
    }
}