package com.playtika.automation.school.java2.task1.vegetable;

public class Potato extends Vegetable {
    private int farinaAmount;

    public Potato(String name, int weight, int calories, int amount, int farinaAmount) {
        super(name, weight, calories, amount);
        this.farinaAmount = farinaAmount;
    }

    public int getFarinaAmount () {
        return farinaAmount;
    }
}