package com.playtika.automation.school.java2.task4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.List;

public class CompareListsImplementation {

    private static Random random = new Random();

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        addMillionToCollections(arrayList);
        LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
        long res;
        res = getTimeToAdd(arrayList) - getTimeToAdd(linkedList);
        System.out.println("Time difference of adding 1000 elements between Array list and Linked list is: " + res);

        res = getTimeToRemove(arrayList) - getTimeToRemove(linkedList);
        System.out.println("Time difference of removing 1000 elements between Array list and Linked list is: " + res);

        res = getTimeToFind(arrayList) - getTimeToFind(linkedList);
        System.out.println("Time difference of search 1000 elements between Array list and Linked list is: " + res);
    }

    private static void addMillionToCollections(List list) {
        for (int i = 0; i < 10000000; i++) {
            int a = random.nextInt();
            list.add(a);
        }
    }

    private static List<Integer> getSelection(List<Integer> list) {
        List<Integer> selection = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            selection.add(list.get(random.nextInt(list.size())));
        }
        return selection;
    }

    private static long getTimeToAdd(List<Integer> list) {
        List<Integer> selection = getSelection(list);
        long start = System.nanoTime();
        for (Integer i : selection) {
            list.add(i);
        }
        long finish = System.nanoTime();
        return finish - start;
    }

    private static long getTimeToRemove(List<Integer> list) {
        List<Integer> selection = getSelection(list);
        long start = System.nanoTime();
        for (Integer i : selection) {
            list.remove(i);
        }
        long finish = System.nanoTime();
        return finish - start;
    }

    private static long getTimeToFind(List<Integer> list) {
        List<Integer> selection = getSelection(list);
        long start = System.nanoTime();
        for (Integer i : selection) {
            list.indexOf(i);
        }
        long finish = System.nanoTime();
        return finish - start;
    }
}