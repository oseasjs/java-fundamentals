package com.java.fundamentals.algoritms.exercises;

import java.util.Random;
import java.util.Scanner;

public class NDiceRoll {

    public static void main(String args[]) {
        System.out.println("Enter the number of dice: ");

        // Initializing the Scanner object to read input
        Scanner input = new Scanner(System.in);
        int numberOfDice = input.nextInt();

        // Initializing the Random object for generating random numbers
        Random ranNum = new Random();

        System.out.print("You rolled: ");
        int total = 0;
        String values = "";

        for (int i = 0; i < numberOfDice; i++) {

            // Generating the random number and storing it in the 'randomNumber' variable
            int randomNumber = ranNum.nextInt(6) + 1;
            total = total + randomNumber;
            values += randomNumber + " ";
        }

        System.out.println("values: " + values);
        System.out.println("Total: " + total);
        input.close();
    }

}
