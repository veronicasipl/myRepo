package com.playtika.automation.school.java2.task1.comparator;

import java.util.Comparator;
import com.playtika.automation.school.java2.task1.vegetable.Vegetable;

public class AmountComparator implements Comparator<Vegetable> {

    public int compare(Vegetable o1, Vegetable o2) {
        return o1.getAmount() - o2.getAmount();
    }
}