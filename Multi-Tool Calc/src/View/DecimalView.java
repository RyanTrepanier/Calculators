/**
 * DecimalView class
 * @author Ryan Trepanier
 * @version 2.0
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
 * This class shows users options for DecimalCalculator objects
 */
public class DecimalView extends JFrame implements ActionListener
{
    JFrame calc;
    Number left, right;

    JTextField results;
    JButton zero, one, two, three, four,
            five, six, seven, eight, nine,
            add, subtract, multiply, divide,
            equals, clear, decimal;
    ArrayList<Number> operands;
    ArrayList<JButton> operators, numbers, computations;
    StringBuilder numberString;
    boolean isFloat, isClear;
    Calculator calculator;

    public DecimalView()
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

        calc = new JFrame("Decimal Calculator");
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
        decimal = new JButton(".");
        equals = new JButton("=");
        numbers.add(zero);
        numbers.add(one);
        numbers.add(two);
        numbers.add(three);
        numbers.add(four);
        numbers.add(five);
        numbers.add(six);
        numbers.add(seven);
        numbers.add(eight);
        numbers.add(nine);
        numbers.add(decimal);

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
        p.add(decimal);
        p.add(equals);

        JPanel operations = new JPanel(new GridLayout(5, 1));
        multiply = new JButton("x");
        divide = new JButton("/");
        add = new JButton("+");
        subtract = new JButton("-");
        clear = new JButton("CLR");
        operators.add(add);
        operators.add(subtract);
        operators.add(multiply);
        operators.add(divide);

        operations.add(multiply);
        operations.add(divide);
        operations.add(add);
        operations.add(subtract);
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
        decimal.addActionListener(this);

        calc.add(results, BorderLayout.NORTH);
        calc.add(p, BorderLayout.CENTER);
        calc.add(operations, BorderLayout.EAST);
        calc.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        checkForOperands(e);
        checkResult();
        checkForOperators(e);
        if (e.getSource() == equals) {
            compute();
        } else if (e.getSource() == clear) {
            numberString.delete(0, numberString.length());
            results.setText(numberString.toString());
            isFloat = false;
        }
    }

    private void checkForOperands(final ActionEvent theEvent)
    {
        if (numbers.contains(theEvent.getSource())) {
            if (isClear) {
                numberString.delete(0, numberString.length());
                results.setText(numberString.toString());
                isClear = false;
            }
            if (theEvent.getSource() == zero) {
                numberString.append("0");
            } else if (theEvent.getSource() == one) {
                numberString.append("1");
            } else if (theEvent.getSource() == two) {
                numberString.append("2");
            } else if (theEvent.getSource() == three) {
                numberString.append("3");
            } else if (theEvent.getSource() == four) {
                numberString.append("4");
            } else if (theEvent.getSource() == five) {
                numberString.append("5");
            } else if (theEvent.getSource() == six) {
                numberString.append("6");
            } else if (theEvent.getSource() == seven) {
                numberString.append("7");
            } else if (theEvent.getSource() == eight) {
                numberString.append("8");
            } else if (theEvent.getSource() == nine) {
                numberString.append("9");
            } else if (theEvent.getSource() == decimal) {
                numberString.append(".");
                isFloat = true;
            }
            results.setText(numberString.toString());
        }
    }

    private void checkResult()
    {
        if (numberString.lastIndexOf(".") != -1) {
            isFloat = true;
        }
    }

    private void checkForOperators(final ActionEvent theEvent)
    {
        if (operators.contains(theEvent.getSource())) {
            numberString.delete(0, numberString.length());
            if (isFloat) {
                operands.add(new Number(Float.parseFloat(results.getText())));
            } else {
                operands.add(new Number(Integer.parseInt(results.getText())));
            }
            computations.add((JButton) theEvent.getSource());
        }
    }

    private void compute()
    {
        numberString.delete(0, numberString.length());
        if (isFloat) {
            operands.add(new Number(Float.parseFloat(results.getText())));
        } else {
            operands.add(new Number(Integer.parseInt(results.getText())));
        }
        for (int op = 0; op < computations.size(); op++) {
            left = operands.remove(0);
            right = operands.remove(0);
            operands.add(0, calculator.doComputation(left, right, computations.remove(0)));
        }
        numberString.append(operands.remove(0).toString());
        results.setText(numberString.toString());
        isClear = true;
    }
}
