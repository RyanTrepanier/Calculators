/**
 * BinaryView class
 * @author Ryan Trepanier
 * @version 1.0
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Model.Calculator;
import Model.Number;

/**
 * This class shows users options for BinaryCalculator objects
 */
public class BinaryView extends JFrame implements ActionListener {

    JFrame calc;
    Number left, right;
    JButton multiply, divide, add, subtract, zero, one,
            two, three, four, five, six, seven, eight, nine,
            clear, equals, convertToDecimal, convertToBinary;
    JTextField results;
    JPanel p;
    JPanel operations;
    ArrayList<Number> operands;
    ArrayList<JButton> operators, numbers, computations, conversions;
    StringBuilder numberString;
    Calculator calculator;
    boolean isClear;
    boolean converting;
    boolean isDecimal;

    public BinaryView()
    {
        results = new JTextField();
        results.setEditable(false);
        results.setHorizontalAlignment(SwingConstants.RIGHT);
        operands = new ArrayList<>();
        operators = new ArrayList<>();
        numbers = new ArrayList<>();
        numberString = new StringBuilder();
        calculator = new Calculator();
        computations = new ArrayList<>();
        conversions = new ArrayList<>();

        calc = new JFrame("Binary Calculator");
        calc.setSize(300, 400);

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
        equals = new JButton("=");

        numbers.add(zero);
        numbers.add(one);

        p = new JPanel(new GridLayout(2, 1));
        p.add(zero);
        p.add(one);

        operations = new JPanel(new GridLayout(8, 1));
        convertToDecimal = new JButton("Binary -> Decimal");
        convertToBinary = new JButton("Decimal -> Binary");
        multiply = new JButton("x");
        divide = new JButton("/");
        add = new JButton("+");
        subtract = new JButton("-");
        clear = new JButton("CLR");
        operators.add(add);
        operators.add(subtract);
        operators.add(multiply);
        operators.add(divide);
        operators.add(convertToDecimal);
        operators.add(convertToBinary);

        operations.add(multiply);
        operations.add(divide);
        operations.add(add);
        operations.add(subtract);
        operations.add(convertToDecimal);
        operations.add(convertToBinary);
        operations.add(clear);
        operations.add(equals);

        zero.addActionListener(this);
        one.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
        add.addActionListener(this);
        subtract.addActionListener(this);
        equals.addActionListener(this);
        clear.addActionListener(this);
        convertToDecimal.addActionListener(this);
        convertToBinary.addActionListener(this);

        calc.add(results, BorderLayout.NORTH);
        calc.add(p, BorderLayout.CENTER);
        calc.add(operations, BorderLayout.EAST);
        calc.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == equals) {
            compute();
        } else if (e.getSource() == clear) {
            clearAll();
        } else {
            checkForOperands(e);
            checkForOperators(e);
        }
    }

    private void checkForOperands(final ActionEvent theEvent)
    {
        if (numbers.contains(theEvent.getSource())) {
            if (isDecimal) {
                numberString.append(((JButton) theEvent.getSource()).getText());
            } else {
                if (theEvent.getSource() == zero) {
                    numberString.append("0");
                } else {
                    numberString.append("1");
                }
            }
            results.setText(numberString.toString());
        }
    }

    private void checkForOperators(final ActionEvent theEvent)
    {
        if (operators.contains(theEvent.getSource())) {
            if (theEvent.getSource() == convertToBinary) {
                clearAll();
                results.setText("Enter the number you wish to convert");
                makeDecimal();
                converting = true;
                isDecimal = true;
                conversions.add((JButton) theEvent.getSource());
                computations.add((JButton) theEvent.getSource());
            } else if (theEvent.getSource() == convertToDecimal) {
                clearAll();
                results.setText("Enter the number you wish to convert");
                makeBinary();
                converting = true;
                isDecimal = false;
                conversions.add((JButton) theEvent.getSource());
                computations.add((JButton) theEvent.getSource());
            } else {
                computations.add((JButton) theEvent.getSource());
                operands.add(new Number(results.getText(), !isDecimal));
                results.setText("");
            }
        }
    }

    private void compute()
    {
        operands.add(new Number(results.getText(), !isDecimal));
        left = operands.remove(0);
        if (conversions.size() != 0) {
                operands.add(0, calculator.doComputation(left, null, conversions.remove(0)));
                computations.remove(0);
                converting = false;
        } else if (conversions.size() == 0 && computations.size() > 0) {
            right = operands.remove(0);
            operands.add(0, calculator.doComputation(left, right, computations.remove(0)));
        }
        numberString.delete(0, numberString.length());
        numberString.append(operands.remove(0).toString());
        operands.clear();
        results.setText(numberString.toString());
    }

    private void makeDecimal()
    {
        isDecimal = true;
        numbers.add(two);
        numbers.add(three);
        numbers.add(four);
        numbers.add(five);
        numbers.add(six);
        numbers.add(seven);
        numbers.add(eight);
        numbers.add(nine);

        operations.remove(clear);
        operations.remove(equals);
        operations.setLayout(new GridLayout(6, 1));
        operations.doLayout();

        p.add(two);
        p.add(three);
        p.add(four);
        p.add(five);
        p.add(six);
        p.add(seven);
        p.add(eight);
        p.add(nine);
        p.add(clear);
        p.add(equals);
        p.setLayout(new GridLayout(4, 3));
        p.doLayout();

        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        clear.addActionListener(this);
        equals.addActionListener(this);
        operands.clear();
        conversions.clear();
        computations.clear();
    }

    private void makeBinary()
    {
        isDecimal = false;
        numbers.remove(two);
        numbers.remove(three);
        numbers.remove(four);
        numbers.remove(five);
        numbers.remove(six);
        numbers.remove(seven);
        numbers.remove(eight);
        numbers.remove(nine);

        p.remove(two);
        p.remove(three);
        p.remove(four);
        p.remove(five);
        p.remove(six);
        p.remove(seven);
        p.remove(eight);
        p.remove(nine);
        p.remove(clear);
        p.remove(equals);
        p.setLayout(new GridLayout(2, 1));
        p.doLayout();

        operands.clear();
        conversions.clear();
        computations.clear();

        operations.add(clear);
        operations.add(equals);
        clear.addActionListener(this);
        equals.addActionListener(this);
        operations.setLayout(new GridLayout(8, 1));
        operations.doLayout();
    }

    private void clearAll()
    {
        numberString.delete(0, numberString.length());
        results.setText("");
        operands.clear();
        computations.clear();
        conversions.clear();
    }
}
