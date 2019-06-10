package task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String inputStr = input.nextLine();
        String outputStr = "";

        //-------- task 1.1 -----------
       int lengthStr = inputStr.length();

        for (int i=lengthStr-1; i>=0; i--) {
            char currSymbol = inputStr.charAt(i);
            outputStr += currSymbol;
        }

        System.out.println(outputStr);

        //-------- task 1.2 -----------
        String[] words = inputStr.split("\\s+");
        int lengthArray = words.length;

        for (int i=0; i<lengthArray; i++) {
           System.out.println(words[i]);
        }

        //-------- task 1.3 -----------
        outputStr = inputStr.replace(' ','*');

        System.out.println(outputStr);

        //-------- task 1.4 -----------
        outputStr = inputStr.toUpperCase();

        System.out.println(outputStr);

        //--------- task 1.5 ----------
        int firstIndex = input.nextInt();
        int secondIndex = input.nextInt();

        outputStr = inputStr.substring(firstIndex-1,secondIndex);

        System.out.println(outputStr);
    }
}