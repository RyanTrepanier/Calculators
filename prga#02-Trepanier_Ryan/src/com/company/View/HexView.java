/**
 * HexView class
 * @author Ryan Trepanier
 * @version 1.0
 */
package com.company.View;

/**
 * The Scanner that reads input
 */
import com.company.Controller.HexCalculator;
import com.company.Model.BinaryNumber;
import com.company.Model.HexNumber;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * This class shows the user a menu of options and calls a calculator object to
 * perform operations chosen by the user
 */
public class HexView implements ActionListener {

    /**
     * Normal text - blue
     */
    public static final String TEXT = "\u001B[34m";

    /**
     * Error text - red
     */
    public static final String ERROR = "\u001B[31m";

    /**
     * The Scanner that reads user input
     */
    private Scanner s = new Scanner(System.in);

    /**
     * The calculator object that performs operations
     */
    private HexCalculator hexCal = new HexCalculator();

    private boolean addOperation;
    private boolean subOperation;
    private boolean multOperation;
    private boolean divOperation;


    JButton a = new JButton("A");
    JButton b = new JButton("B");
    JButton c = new JButton("C");
    JButton d = new JButton("D");
    JButton e = new JButton("E");
    JButton f = new JButton("F");
    JButton convert2Decimal;
    JButton convertDec2Hex;
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

    HexNumber left;
    HexNumber right;

    public HexView() {
        JFrame hexFrame = new JFrame("Hexadecimal Calculator");
        hexFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        hexFrame.setSize(500, 500);

        JPanel operations = new JPanel(new GridLayout(8, 1));

        convert2Decimal = new JButton("Convert to Decimal");
        convertDec2Hex = new JButton("Convert to Hexadecimal");

        results.setText("");
        results.setEditable(false);

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
        p.add(a);
        p.add(b);
        p.add(c);
        p.add(d);
        p.add(e);
        p.add(f);

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
        operations.add(convert2Decimal);
        operations.add(convertDec2Hex);
        operations.add(clear);

        multiply.addActionListener(this);
        divide.addActionListener(this);
        add.addActionListener(this);
        subtract.addActionListener(this);
        clear.addActionListener(this);
        equals.addActionListener(this);
        convertDec2Hex.addActionListener(this);
        convert2Decimal.addActionListener(this);
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
        a.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);
        e.addActionListener(this);
        f.addActionListener(this);

        hexFrame.add(results, BorderLayout.NORTH);
        hexFrame.add(operations, BorderLayout.EAST);
        hexFrame.add(p, BorderLayout.CENTER);
        hexFrame.setVisible(true);
    }

    /**
     * This method accesses a long value entered by the user
     * @param message the String to be printed
     * @return inputValue the long entered by the user
     */
    private long getLong(String message) {
        System.out.println(message);
        long inputValue = s.nextLong();
        return  inputValue;
    }

    /**
     * This method creates and accesses a HexNumber created for the user
     * @param message the String to be printed
     * @return hexValue the HexNumber for the user
     */
    private HexNumber getHex(String message) {
        System.out.println(message);
        String hex1 = s.next();

        HexNumber hexValue = null;
        if (checkHex(hex1)) {
            hexValue = new HexNumber(hex1);
        }
        else {
            System.out.println(ERROR + "The number needs to contain 0-9 and A-F");

        }

        return hexValue;
    }

    /**
     * This method shows the user a menu and prompts for a choice
     * @return choice the integer representing the chosen operation
     */
    private int showMenuAndChoose() {
        System.out.print(TEXT + "Please choose one of the following: \n"
                + "1. Add two hex numbers \n"
                + "2. Subtract two hex numbers \n"
                + "3. Multiply two hex numbers \n"
                + "4. Divide two hex numbers \n"
                + "5. Convert decimal to hex \n"
                + "6. Convert hex to decimal \n"
                + "7. Test mode. \n"
                + "8. Exit \n" + TEXT);

        int choice = s.nextInt();
        return choice;
    }

    /**
     * This method performs the execution chosen by the user
     * @param functionChoice the operation chosen by the user
     */
    private void execute(int functionChoice) {
        switch (functionChoice) {
            case 1: {
                HexNumber b1 = getHex("The 1st hex value:");
                HexNumber b2 = getHex("The 2st hex value:");
                System.out.println("The sum of" + b1 + "and " + b2 + " =" + this.hexCal.add(b1, b2));
                break;
            }
            case 2: {

                HexNumber b1 = getHex("The 1st hex value:");
                HexNumber b2 = getHex("The 2st hex value:");

                System.out.println("Subtraction of" + b1 + "and " + b2 + " =" + hexCal.subtract(b1, b2));
                break;
            }
            case 3: {
                HexNumber b1 = getHex("The 1st hex value:");
                HexNumber b2 = getHex("The 2st hex value:");

                System.out.println("Multi of" + b1 + "and " + b2 + " =" + hexCal.multiply(b1, b2));
                break;
            }
            case 4: {

                HexNumber b1 = getHex("The 1st hex value:");
                HexNumber b2 = getHex("The 2st hex value:");

                System.out.println("Multi of" + b1 + "and " + b2 + " =" + this.hexCal.divide(b1, b2) +
                        "and remainder of" + hexCal.modulo(b1, b2));
                break;
            }
            case 5: {
                long dec = getLong("Input decimal value: ");
                System.out.println("The hex value: " + this.hexCal.convertDec2Hex(dec));
                break;
            }
            case 6: {
                HexNumber b = getHex("The hex value:");

                System.out.println("The decimal value: " + this.hexCal.convert2Decimal(b.toString()));
                break;
            }
            case 7: {
                break;
            }
        }
    }

    /**
     * This method verifies that the value is a hexadecimal number
     * @param a the String being tested
     * @return true or false depending on the String
     */
    private static boolean checkHex(String a) {
        boolean isHex = true;
        for (int i = 0; i < a.toString().length(); i++) {
            char tempB = a.toString().charAt(i);
            if (tempB != '0' || tempB != '1' || tempB != '2' || tempB != '3' || tempB != '4' || tempB != '5' ||
                tempB != '6' || tempB != '7' || tempB != '8' || tempB != '9' || tempB != 'a' || tempB != 'b' ||
                    tempB != 'c' || (tempB != 'd') || (tempB != 'e') || (tempB != 'f')) {
                isHex = false;
            }
        }
        return true;
    }

    /**
     * This method performs the execute method with the result of showMenuAndChoose as a parameter
     */
    public void show() {

        execute(showMenuAndChoose());

    }

    public void addPushed() {
        left = new HexNumber(results.getText());
        results.setText("");
    }

    public void equalsPushed() {
        right = new HexNumber(results.getText());
    }

    public void subPushed() {
        left = new HexNumber(results.getText());
        results.setText("");
    }

    public void multPushed() {
        left = new HexNumber(results.getText());
        results.setText("");
    }

    public void divPushed() {
        left = new HexNumber(results.getText());
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
        } else if (e.getSource() == a) {
            results.setText(results.getText() + "A");
        } else if (e.getSource() == b) {
            results.setText(results.getText() + "B");
        } else if (e.getSource() == c) {
            results.setText(results.getText() + "C");
        } else if (e.getSource() == d) {
            results.setText(results.getText() + "D");
        } else if (e.getSource() == this.e) {
            results.setText(results.getText() + "E");
        } else if (e.getSource() == f) {
            results.setText(results.getText() + "F");
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
                result = hexCal.add(left, right).getDecimal();
            } else if (subOperation) {
                result = hexCal.subtract(left, right).getDecimal();
            } else if (multOperation) {
                result = hexCal.multiply(left, right).getDecimal();
            } else if (divOperation) {
                result = hexCal.divide(left, right).getDecimal();
            }
            addOperation = false;
            subOperation = false;
            multOperation = false;
            divOperation = false;

            results.setText(hexCal.convertDec2Hex(result));

        } else if (e.getSource() == clear) {
            results.setText("");
        } else if (e.getSource() == convert2Decimal) {
            var decimal = new HexNumber(results.getText());
            results.setText(hexCal.convertHex2Dec(results.getText()) + "");
        } else if (e.getSource() == convertDec2Hex) {
            results.setText(hexCal.convertDec2Hex(Long.parseLong(results.getText())));
        }
    }
}
