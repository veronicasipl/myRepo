package com.playtika.automation.school.java2.common;

import java.util.ArrayList;

import com.playtika.automation.school.java2.task1.vegetable.Vegetable;
import com.playtika.automation.school.java2.task1.factory.VegetableFactory;
import com.playtika.automation.school.java2.task2.Student;
import com.playtika.automation.school.java3.task1.exception.IngredientDataIsInvalidException;
import com.playtika.automation.school.java2.task1.constant.VegetableType;

public class Helper {

    public static ArrayList<Student> createStudentsList() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "John", "F", 19));
        students.add(new Student(2, "John", "F", 19));
        students.add(new Student(3, "Charlie", "S", 20));
        students.add(new Student(4, "Vanessa", "D", 19));
        students.add(new Student(5, "Ed", "S", 21));
        students.add(new Student(6, "Julia", "K", 22));
        students.add(new Student(7, "Brad", "D", 18));
        students.add(new Student(8, "Hilary", "D", 23));
        students.add(new Student(9, "Yuri", "L", 25));
        students.add(new Student(10, "Maria", "V", 23));
        return students;
    }

    public static ArrayList<Vegetable> createVegetablesList() throws IngredientDataIsInvalidException {

        Vegetable potato = VegetableFactory.getVegetable(VegetableType.POTATO, "Potato", 100, 222, 100, 100);
        Vegetable onion = VegetableFactory.getVegetable(VegetableType.ONION, "Onion", 10, 2, 1,0);
        Vegetable carrot = VegetableFactory.getVegetable(VegetableType.CARROT, "Carrot", 12, 15, 1, 0);
        ArrayList<Vegetable> vegetablesList = new ArrayList<>();
        vegetablesList.add(potato);
        vegetablesList.add(onion);
        vegetablesList.add(carrot);
        if (validateList(vegetablesList)) {
            return vegetablesList;
        } else {
            throw new IngredientDataIsInvalidException("Check ingredients data!");
        }
    }

    public static boolean validateList(ArrayList<Vegetable> vegetablesList) {
        for (Vegetable item : vegetablesList) {
            if (item.getName() == null || item.getAmount() == 0 || item.getWeight() == 0) {
                return false;
            }
        }
        return true;
    }
}