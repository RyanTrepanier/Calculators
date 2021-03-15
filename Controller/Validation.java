/**
 * Validation class
 * @author Ryan Trepanier
 * @version 1.0
 */
package com.company.Controller;

/**
 * to use BigIntegers
 */
import java.math.BigInteger;

/**
 * Scanner to read input
 */
import java.util.Scanner;

/**
 * This class validates user input for specific menus
 */
public class Validation {

    /**
     * Error text - red
     */
    public static final String ERROR = "\u001B[31m";

    /**
     * This method validates the choice in calculator
     * @param console the Scanner used to collect input
     * @return choice the valid input
     */
    public static int validateCalculatorMenu(Scanner console) {
        String invalidChoice = "";
        int choice = 0;
        while (!console.hasNextInt()) {
            invalidChoice = console.next();
        }
        if (console.hasNextInt()) {
            choice = console.nextInt();
            while (choice == 0 || choice > 6) {
                System.out.println(ERROR + "Enter a number from the list of choices.");
            }
        }
        return choice;
    }

    /**
     * This method validates a choice of numbers 1-7
     * @param console the Scanner to read input
     * @return choice the valid input
     */
    public static int validateTimePeriod(Scanner console) {
        String notANumber;
        if (!console.hasNextInt()) {
            notANumber = console.next();
            System.out.println(ERROR + "\nNot a valid entry, try again.");
        }
        int choice = console.nextInt();
        if (choice < 1 || choice > 7) {
            System.out.println(ERROR + "\nNot a valid entry, try again.");
        }
        return choice;
    }

    /**
     * This method validates that input is a double
     * @param console the Scanner that reads input
     * @return the next double that is entered
     */
    public static double validateDouble(Scanner console) {
        String invalidDouble = "";
        while (!console.hasNextDouble()) {
            invalidDouble = console.next();
            System.out.println(ERROR + "\nNot a valid entry, try again.");
        }
        return console.nextDouble();
    }

    /**
     * This method validates that a choice is an integer
     * @param console the Scanner that reads input
     * @return the next integer entered
     */
    public static int validateOperation(Scanner console) {
        String invalidOperation = "";
        while (!console.hasNextInt()) {
            invalidOperation = console.next();
            System.out.println(ERROR + "\nNot a valid entry, try again.");
        }
        return console.nextInt();
    }

    /**
     * This method validates that a value is a BigInteger
     * @param console Scanner to read input
     * @return the next BigInteger
     */
    public static BigInteger validateBigInteger(Scanner console) {
        String invalidNumber = "";
        while (!console.hasNextInt()) {
            invalidNumber = console.next();
            System.out.println(ERROR + "\nNot a valid entry, try again.");
        }
        return console.nextBigInteger();
    }

    /**
     * This method validates a number a between 1 and 3
     * @param console Scanner to read input
     * @return choice the valid choice
     */
    public static int validateBandwidthCalcChoice(Scanner console) {
        String invalidChoice = "";
        int choice = 0;
        while (!console.hasNextInt()) {
            invalidChoice = console.next();
        }
        if (console.hasNextInt()) {
            choice = console.nextInt();
            while (choice == 0 || choice > 4) {
                System.out.println(ERROR + "Enter a number from the list of choices.");
            }
        }
        return choice;
    }

    /**
     * This method validatets a number is between 1 and 9
     * @param console Scanner to read input
     * @return choice the valid input
     */
    public static int validateDataUnitConverterFileType(Scanner console) {
        String invalidChoice = "";
        int choice = 0;
        while (!console.hasNextInt()) {
            invalidChoice = console.next();
        }
        if (console.hasNextInt()) {
            choice = console.nextInt();
            while (choice == 0 || choice > 10) {
                System.out.println(ERROR + "Enter a number from the list of choices.");
            }
        }
        return choice;
    }

    /**
     * This method validates a number is between 1 and 5
     * @param console Scanner to read input
     * @return choice the valid input
     */
    public static int validate1Through5(Scanner console) {
        String invalidChoice = "";
        int choice = 0;
        while (!console.hasNextInt()) {
            invalidChoice = console.next();
        }
        if (console.hasNextInt()) {
            choice = console.nextInt();
            while (choice == 0 || choice > 6) {
                System.out.println(ERROR + "Enter a number from the list of choices.");
            }
        }
        return choice;
    }
}
