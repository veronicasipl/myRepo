package task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int inputInt = input.nextInt();
        String outputStr = "";

        switch (inputInt) {
            case 1:
                outputStr = "Monday";
                break;
            case 2:
                outputStr = "Tuesday";
                break;
            case 3:
                outputStr = "Wednesday";
                break;
            case 4:
                outputStr = "Thursday";
                break;
            case 5:
                outputStr = "Friday";
                break;
            case 6:
                outputStr = "Saturday";
                break;
            case 7:
                outputStr = "Sunday";
                break;
            default:
                outputStr = "unknown";
        }
        System.out.println(outputStr);
    }
}
