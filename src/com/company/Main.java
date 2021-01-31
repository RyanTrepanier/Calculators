package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        var sc = new Scanner(System.in);

        System.out.print("Enter a numeric value: ");
        double d1 = 0;
        double d2 = 0;
        double result = 0;
        try {
            d1 = sc.nextDouble();
            System.out.print("Enter a numeric value: ");
            d2 = sc.nextDouble();

        } catch (InputMismatchException e) {
            e.getMessage();
            System.out.println("Couldn't format as a number");
        }
        result = d1 / d2;

        System.out.println("The answer is " + result);
    }

}

