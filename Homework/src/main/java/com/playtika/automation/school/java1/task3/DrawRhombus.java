package com.playtika.automation.school.java1.task3;

import java.util.Scanner;
import java.lang.StringBuilder;

public class DrawRhombus {

    private static final String ASTERISK = "*";
    private static final String SPACE = " ";
    private static Scanner inputReader;

    public static void main(String[] args) {
        inputReader = new Scanner(System.in);
        int sideSize = inputReader.nextInt();
        int rowLength;
        rowLength = (sideSize * 2) - 1;
        int height = rowLength;
        int halfHeight = (height + 1) / 2;
        drawTopPartAndMiddleLine(sideSize, height);
        drawBottomPart(sideSize, height);
        inputReader.close();
    }

    private static void drawTopPartAndMiddleLine(int sideSize, int height) {
        int rowLength = (sideSize * 2) - 1;
        int halfHeight = (height + 1) / 2;
        int middleSymbolIndex = (rowLength + 1) / 2;
        for (int i = 0; i < halfHeight; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 1; j <= rowLength; j++) {
                if (j == middleSymbolIndex - i || j == middleSymbolIndex + i) {
                    stringBuilder.append(ASTERISK);
                } else {
                    stringBuilder.append(SPACE);
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }

    private static void drawBottomPart(int sideSize, int height) {
        int rowLength = (sideSize * 2) - 1;
        int halfHeight = (height + 1) / 2;
        for (int i = 1; i <= halfHeight - 1; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < rowLength; j++) {
                if (j == rowLength - i - 1 || j == i) {
                    stringBuilder.append(ASTERISK);
                } else {
                    stringBuilder.append(SPACE);
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }
}