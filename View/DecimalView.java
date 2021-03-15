/**
 * DecimalView class
 * @author Ryan Trepanier
 * @version 1.0
 */
package com.company.View;

/**
 * The Scanner to read user input
 */
import com.company.Controller.DecimalCalculator;
import com.company.Model.DecimalNumber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * This class shows users options for DecimalCalculator objects
 */
public class DecimalView implements ActionListener {

    /**
     * Normal text - blue
     */
    public static final String TEXT = "\u001B[34m";

    /**
     * Error text - red
     */
    public static final String ERROR = "\u001B[31m";

    /**
     * The Scanner to read input
     */
    private Scanner s = new Scanner(System.in);

    /**
     * The DecimalCalculator that will perform operations
     */
    private DecimalCalculator decCal = new DecimalCalculator();

    private boolean addOperation;
    private boolean subOperation;
    private boolean multOperation;
    private boolean divOperation;

    DecimalNumber left;
    DecimalNumber right;

    JTextField results = new JTextField();
    JButton zero;
    JButton one;
    JButton two;
    JButton three;
    JButton four;
    JButton five;
    JButton six;
    JButton seven;
    JButton eight;
    JButton nine;

    JButton add;
    JButton subtract;
    JButton multiply;
    JButton divide;
    JButton equals;
    JButton clear;

    public DecimalView() {
        JFrame decimalFrame = new JFrame("Decimal Calculator");
        decimalFrame.setSize(400, 400);

        JPanel operations = new JPanel(new GridLayout(6, 1));
        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        JPanel p = new JPanel(new GridLayout(4, 4));
        p.add(zero);
        p.add(one);
        p.add(two);
        p.add(three);
        p.add(four);
        p.add(five);
        p.add(six);
        p.add(seven);
        p.add(eight);
        p.add(nine);

        multiply = new JButton("x");
        divide = new JButton("/");
        add = new JButton("+");
        subtract = new JButton("-");
        clear = new JButton("CLR");
        equals = new JButton("=");

        operations.add(multiply);
        operations.add(divide);
        operations.add(add);
        operations.add(subtract);
        operations.add(equals);
        operations.add(clear);

        multiply.addActionListener(this);
        divide.addActionListener(this);
        add.addActionListener(this);
        subtract.addActionListener(this);
        clear.addActionListener(this);
        equals.addActionListener(this);
        zero.addActionListener(this);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);

        decimalFrame.add(results, BorderLayout.NORTH);
        decimalFrame.add(p, BorderLayout.CENTER);
        decimalFrame.add(operations, BorderLayout.EAST);
        decimalFrame.setVisible(true);
    }

    /**
     * This method accesses the user's input
     * @param message the String to be printed
     * @return inputValue the user's input
     */
    private long getLong(String message) {
        System.out.println(message);
        long inputValue = s.nextLong();
        return  inputValue;
    }

    /**
     * This method creates a DecimalNumber object for the user
     * @param message the String to be printed
     * @return decValue the DecimalNumber created for the user
     */
    private DecimalNumber getDecimal(String message) {
        System.out.println(message);
        DecimalNumber decValue = null;
        if (s.hasNextDouble()) {
            double dec1 = s.nextDouble();
            decValue = new DecimalNumber(dec1);
        } else {
            System.out.println(ERROR + "The number needs to contain numbers only.");
        }
        return decValue;
    }

    /**
     * This method shows the user a menu and prompts for a choice
     * @return choice the user's integer input
     */
    private int showMenuAndChoose() {
        System.out.print(TEXT + "Please choose one of the following: \n"
                + "1. Add two decimal numbers \n"
                + "2. Subtract two decimal numbers \n"
                + "3. Multiply two decimal numbers \n"
                + "4. Divide two decimal numbers \n"
                + "5. Exit \n" + TEXT);

        int choice = s.nextInt();
        return choice;
    }

    /**
     * This method performs the calculation requested by the user
     * @param functionChoice the operation choice
     */
    private void execute(int functionChoice) {
        switch (functionChoice) {
            case 1: {
                DecimalNumber b1 = getDecimal("The 1st decimal value:");
                DecimalNumber b2 = getDecimal("The 2st decimal value:");
                System.out.println("The sum of" + b1 + "and " + b2 + " =" + this.decCal.add(b1, b2));
                break;
            }
            case 2: {

                DecimalNumber b1 = getDecimal("The 1st decimal value:");
                DecimalNumber b2 = getDecimal("The 2st decimal value:");

                System.out.println("Subtraction of" + b1 + "and " + b2 + " =" + decCal.subtract(b1, b2));
                break;
            }
            case 3: {
                DecimalNumber b1 = getDecimal("The 1st decimal value:");
                DecimalNumber b2 = getDecimal("The 2st decimal value:");

                System.out.println("Multi of" + b1 + "and " + b2 + " =" + decCal.multiply(b1, b2));
                break;
            }
            case 4: {

                DecimalNumber b1 = getDecimal("The 1st decimal value:");
                DecimalNumber b2 = getDecimal("The 2st decimal value:");

                System.out.println("Multi of" + b1 + "and " + b2 + " =" + this.decCal.divide(b1, b2) +
                        "and remainder of" + decCal.modulo(b1, b2));
                break;
            }
            case 5: {
                break;
            }
        }
    }

    /**
     * This method performs the execute method, using the result of showMenuAndChoose as a parameter
     */
    public void show() {

        execute(showMenuAndChoose());

    }

    public void addPushed() {
        left = new DecimalNumber(Double.parseDouble(results.getText()));
        results.setText("");
    }

    public void equalsPushed() {
        right = new DecimalNumber(Double.parseDouble(results.getText()));
    }

    public void subPushed() {
        left = new DecimalNumber(Double.parseDouble(results.getText()));
        results.setText("");
    }

    public void multPushed() {
        left = new DecimalNumber(Double.parseDouble(results.getText()));
        results.setText("");
    }

    public void divPushed() {
        left = new DecimalNumber(Double.parseDouble(results.getText()));
        results.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == one) {
            results.setText(results.getText() + "1");
        } else if (e.getSource() == zero) {
            results.setText(results.getText() + "0");
        } else if (e.getSource() == two) {
            results.setText(results.getText() + "2");
        } else if (e.getSource() == three) {
            results.setText(results.getText() + "3");
        } else if (e.getSource() == four) {
            results.setText(results.getText() + "4");
        } else if (e.getSource() == five) {
            results.setText(results.getText() + "5");
        } else if (e.getSource() == six) {
            results.setText(results.getText() + "6");
        } else if (e.getSource() == seven) {
            results.setText(results.getText() + "7");
        } else if (e.getSource() == eight) {
            results.setText(results.getText() + "8");
        } else if (e.getSource() == nine) {
            results.setText(results.getText() + "9");
        }
        if (e.getSource() == add) {
            addOperation = true;
            addPushed();
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
            if (addOperation) {
                result = decCal.add(left, right).getDecimal();
            } else if (subOperation) {
                result = decCal.subtract(left, right).getDecimal();
            } else if (multOperation) {
                result = decCal.multiply(left, right).getDecimal();
            } else if (divOperation) {
                result = decCal.divide(left, right).getDecimal();
            }
            addOperation = false;
            subOperation = false;
            multOperation = false;
            divOperation = false;

            results.setText(result + "");
        }
        else if (e.getSource() == clear) {
            results.setText("");
        }
    }
}
