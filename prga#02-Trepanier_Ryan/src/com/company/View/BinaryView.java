/**
 * BinaryView class
 * @author Ryan Trepanier
 * @version 1.0
 */
package com.company.View;

/**
 * The Scanner that reads user input
 */
import com.company.Controller.BinaryCalculator;
import com.company.Model.BinaryNumber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * This class shows users options for BinaryCalculator objects
 */
public class BinaryView implements ActionListener {

    /**
     * Normal text color - blue
     */
    public static final String TEXT = "\u001B[34m";

    /**
     * Error text color - red
     */
    public static final String ERROR = "\u001B[31m";

    /**
     * The Scanner that reads user input
     */
    private Scanner s = new Scanner(System.in);

    BinaryNumber left;
    BinaryNumber right;

    private boolean addOperation;
    private boolean subOperation;
    private boolean multOperation;
    private boolean divOperation;

    /**
     * The BinaryCalculator that will perform operations
     */
    private BinaryCalculator binCal = new BinaryCalculator();

    JButton multiply = new JButton("x");
    JButton divide = new JButton("/");
    JButton add = new JButton("+");
    JButton subtract = new JButton("-");
    JButton equals = new JButton("=");
    JButton clear = new JButton("CLR");
    JTextField results = new JTextField();
    JButton zero = new JButton("0");
    JButton one = new JButton("1");
    JButton convert2Decimal;

    public BinaryView() {
        JFrame binFrame = new JFrame("Binary Calculator");
        binFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        binFrame.setSize(500, 500);
        JPanel operations = new JPanel(new GridLayout(6, 1));

        convert2Decimal = new JButton("Convert to Decimal");

        results.setText("");
        results.setEditable(false);
        operations.add(multiply);
        operations.add(divide);
        operations.add(add);
        operations.add(subtract);
        operations.add(equals);
        operations.add(convert2Decimal);
        operations.add(clear);

        JPanel numbers = new JPanel();

        numbers.add(zero);
        numbers.add(one);
        binFrame.add(numbers, BorderLayout.CENTER);

        zero.addActionListener(this);
        one.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
        add.addActionListener(this);
        subtract.addActionListener(this);
        equals.addActionListener(this);
        clear.addActionListener(this);
        convert2Decimal.addActionListener(this);


        addOperation = false;
        subOperation = false;
        multOperation = false;
        divOperation = false;

        binFrame.add(operations, BorderLayout.EAST);
        binFrame.add(results, BorderLayout.NORTH);
        binFrame.setVisible(true);
    }


    /**
     * This method accesses the long value inputted by users
     * @param message the String to be printed
     * @return inputValue the number entered by the user
     */
    private long getLong(String message) {
        System.out.println(message);
        long inputValue = s.nextLong();
        return  inputValue;
    }

    /**
     * This method creates a BinaryNumber object and returns it to the user
     * @param message the String to be printed
     * @return binValue the BinaryNumber for the user
     */
    public BinaryNumber getBinary(String message) {
        System.out.println(message);
        String bin1 = s.next();

        BinaryNumber binValue = null;
        if (checkBinary(bin1)) {
            binValue = new BinaryNumber(bin1);
        }
        else {
            System.out.println(ERROR + "The number needs to contain 0 and 1 only.");

        }

        return binValue;
    }

    /**
     * This method displays a menu and prompts the user to choose
     * @return choice the operation the user wants
     */
    private int showMenuAndChoose() {
        System.out.print(TEXT + "Please choose one of the following: \n"
                + "1. Add two binary numbers \n"
                + "2. Subtract two binary numbers \n"
                + "3. Multiply two binary numbers \n"
                + "4. Divide two binary numbers \n"
                + "5. Convert decimal to binary \n"
                + "6. Convert binary to decimal \n"
                + "7. Test mode. \n"
                + "8. Exit \n" + TEXT);

        int choice = s.nextInt();
        return choice;
    }

    /**
     * This method calls a calculator to perform the operation chosen by the user
     * @param functionChoice the operation chosen by the user
     */
    public void execute(int functionChoice) { //TAKE IN ACTION EVENT e
        switch (functionChoice) {
            case 1: {
                BinaryNumber b1 = getBinary("The 1st binary value:");
                BinaryNumber b2 = getBinary("The 2st binary value:");
                System.out.println("The sum of " + b1 + " and " + b2 + " = " + this.binCal.add(b1, b2));
                break;
            }
            case 2: {

                BinaryNumber b1 = getBinary("The 1st binary value:");
                BinaryNumber b2 = getBinary("The 2st binary value:");

                System.out.println("Subtraction of " + b1 + " and " + b2 + " = " + binCal.subtract(b1, b2));
                break;
            }
            case 3: {
                BinaryNumber b1 = getBinary("The 1st binary value:");
                BinaryNumber b2 = getBinary("The 2st binary value:");

                System.out.println("Multiplication of " + b1 + " and " + b2 + " = " + binCal.multiply(b1, b2));
                break;
            }
            case 4: {

                BinaryNumber b1 = getBinary("The 1st binary value:");
                BinaryNumber b2 = getBinary("The 2st binary value:");

                System.out.println("Division of " + b1 + " and " + b2 + " = " + this.binCal.divide(b1, b2) +
                        "and remainder of " + binCal.modulo(b1, b2));
                break;
            }
            case 5: {
                long dec = getLong("Input decimal value: ");
                System.out.println("The binary value: " + this.binCal.convert2Binary(dec));
                break;
            }
            case 6: {
                BinaryNumber b = getBinary("The binary value:");

                System.out.println("The decimal value: " + this.binCal.convert2Decimal(b.toString()));
                break;
            }
            case 7: {
                break;
            }
        }
    }

    /**
     * This method confirms that a String is indeed a binary number
     * @param a the String being tested
     * @return true or false based on a being a binary number or not
     */
    private static boolean checkBinary(String a) {
        boolean isBin = true;
        for (int i = 0; i < a.toString().length(); i++) {
            int tempB = a.toString().charAt(i);
            if (tempB != '0' && tempB != '1') {
                isBin = false;
            }
        }
        return isBin;
    }

    /**
     * This method performs the execute operation with the result of showMenuAndChoose as a parameter
     */
    public void show() {


        execute(showMenuAndChoose());

    }

    public void addPushed() {
        left = new BinaryNumber(results.getText());
        results.setText("");
    }

    public void equalsPushed() {
        right = new BinaryNumber(results.getText());
    }

    public void subPushed() {
        left = new BinaryNumber(results.getText());
        results.setText("");
    }

    public void multPushed() {
        left = new BinaryNumber(results.getText());
        results.setText("");
    }

    public void divPushed() {
        left = new BinaryNumber(results.getText());
        results.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == one) {
            results.setText(results.getText() + "1");
        } else if (e.getSource() == zero) {
            results.setText(results.getText() + "0");
        } if (e.getSource() == add) {
            addOperation = true;
            addPushed();
            System.out.println(addOperation);
        } else if (e.getSource() == subtract) {
            subOperation = true;
            subPushed();
        } else if (e.getSource() == multiply) {
            multOperation = true;
            multPushed();
        } else if (e.getSource() == divide) {
            divOperation = true;
            divPushed();
        } else if (e.getSource() == equals) {
            equalsPushed();
            long result = 0;
            System.out.println(addOperation);
            if (addOperation) {
                result = binCal.add(left, right).getDecimal();
            } else if (subOperation) {
                result = binCal.subtract(left, right).getDecimal();
            } else if (multOperation) {
                result = binCal.multiply(left, right).getDecimal();
            } else if (divOperation) {
                result = binCal.divide(left, right).getDecimal();
            }
            addOperation = false;
            subOperation = false;
            multOperation = false;
            divOperation = false;

            results.setText(binCal.convert2Binary(result));

        } else if (e.getSource() == clear) {
            results.setText("");
        } else if (e.getSource() == convert2Decimal) {
            var decimal = new BinaryNumber(results.getText());
            results.setText(binCal.convert2Decimal(results.getText()) + "");
        }
    }
}
