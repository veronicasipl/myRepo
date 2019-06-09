package task4;

import java.util.Arrays;
import java.util.Scanner;


public class Main4 {
    public static void main(String[] args) {
        String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel",
                "Neda", "Aaron", "Kate"};
        int[] results = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 26};

        int namesLength = names.length;

//--------------task1-------------
        for(int k=0; k<namesLength; k++) {
            for (int j = 0; j < namesLength-1; j++) {
                if (results[j] > results[j + 1]) {
                    int temp = results[j];
                    results[j] = results[j + 1];
                    results[j + 1] = temp;

                    String temp2 = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp2;
                }
            }
        }

        for (int i=0; i < namesLength; i++) {
            String output = names[i] + " - " + Integer.toString(results[i]);
            System.out.println(output);
        }
//---------------task2 (optional)-------------
        Scanner input = new Scanner(System.in);
        int inputPlace = input.nextInt();

        System.out.println(getNameAndResult(inputPlace,names,results));

        System.out.println(getNameAndResult(2,names,results));

        System.out.println(getNameAndResult(1,names,results));
    }

    private static String getNameAndResult(int place, String[] names, int[] results){
        String output = names[place-1] + " - " + Integer.toString(results[place-1]);
        return output;
    }
}