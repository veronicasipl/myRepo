package task3;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int inputInt = input.nextInt();
        int length = (inputInt * 2)-1;
        int height = length;
        String line = "";
        String symbol = "*";
        String space = " ";

        int halfHeight = (height+1)/2;
        int middleSymbolIndex = (length+1)/2;

        // draw top part and middle line
        for (int i=0; i<halfHeight; i++) {
            for(int j=1; j<=length; j++){

                if (j==middleSymbolIndex-i || j==middleSymbolIndex+i){
                    line += symbol;
                }
                else{
                    line += space;
                }
            }

            System.out.println(line);
            line="";
        }

        //draw bottom part
        for (int i=1; i<=halfHeight-1; i++) {
            for(int j=0; j<length; j++){

                if (j==length-i-1 || j==i){
                    line += symbol;
                }
                else{
                    line += space;
                }
            }

            System.out.println(line);
            line="";
        }

    }
}