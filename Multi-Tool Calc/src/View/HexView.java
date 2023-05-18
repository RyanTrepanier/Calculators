/**
 * HexView class
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
 * This class shows the user a menu of options and calls a calculator object to
 * perform operations chosen by the user
 */
public class HexView extends JFrame implements ActionListener {

    JFrame calc;
    Number left, right;
    JButton a, b, c, d, e, f, zero, one, two,
            three, four, five, six, seven, eight, nine,
            add, subtract, multiply, divide, equals, clear,
            convertToDecimal, convertToHex;
    JTextField results;
    ArrayList<Number> operands;
    ArrayList<JButton> operators, numbers, computations, conversions;
    StringBuilder numberString;
    Calculator calculator;
    boolean isClear;

    public HexView()
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

        calc = new JFrame("Hexadecimal Calculator");
        calc.setSize(400, 500);

        JPanel p = new JPanel(new GridLayout(4, 4));
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
        a = new JButton("A");
        b = new JButton("B");
        c = new JButton("C");
        d = new JButton("D");
        e = new JButton("E");
        f = new JButton("F");
        equals = new JButton("=");
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
        numbers.add(a);
        numbers.add(b);
        numbers.add(c);
        numbers.add(d);
        numbers.add(e);
        numbers.add(f);


        JPanel operations = new JPanel(new GridLayout(8, 1));
        multiply = new JButton("x");
        divide = new JButton("/");
        add = new JButton("+");
        subtract = new JButton("-");
        clear = new JButton("CLR");
        convertToDecimal = new JButton("Hex -> Decimal");
        convertToHex = new JButton("Decimal -> Hex");
        operators.add(add);
        operators.add(subtract);
        operators.add(multiply);
        operators.add(divide);
        operators.add(convertToDecimal);
        operators.add(convertToHex);

        operations.add(multiply);
        operations.add(divide);
        operations.add(add);
        operations.add(subtract);
        operations.add(equals);
        operations.add(convertToDecimal);
        operations.add(convertToHex);
        operations.add(clear);

        multiply.addActionListener(this);
        divide.addActionListener(this);
        add.addActionListener(this);
        subtract.addActionListener(this);
        clear.addActionListener(this);
        equals.addActionListener(this);
        convertToHex.addActionListener(this);
        convertToDecimal.addActionListener(this);
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

        calc.add(results, BorderLayout.NORTH);
        calc.add(p, BorderLayout.CENTER);
        calc.add(operations, BorderLayout.EAST);
        calc.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        checkForOperands(e);
        checkForOperators(e);
        if (e.getSource() == equals) {
            compute();
        } else if (e.getSource() == clear) {
            numberString.delete(0, numberString.length());
            results.setText(numberString.toString());
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
            } else if (theEvent.getSource() == a) {
                numberString.append("A");
            } else if (theEvent.getSource() == b) {
                numberString.append("B");
            } else if (theEvent.getSource() == c) {
                numberString.append("C");
            } else if (theEvent.getSource() == d) {
                numberString.append("D");
            } else if (theEvent.getSource() == e) {
                numberString.append("E");
            } else if (theEvent.getSource() == f) {
                numberString.append("F");
            }
            results.setText(numberString.toString());
        }
    }

    private void checkForOperators(final ActionEvent theEvent)
    {
        if (operators.contains(theEvent.getSource())) {
            if (theEvent.getSource() != convertToHex && theEvent.getSource() != convertToDecimal) {
                computations.add((JButton) theEvent.getSource());
            } else {
                computations.add((JButton) theEvent.getSource());
                conversions.add((JButton) theEvent.getSource());
            }
        }
    }

    private void compute()
    {
        operands.add(new Number(results.getText(), false));
        for (int op = 0; op < computations.size(); op++) {
            left = operands.remove(0);
            if (conversions.size() != 0) {
                operands.add(0, calculator.doComputation(left, null, conversions.remove(0)));
                computations.remove(0);
            } else {
                right = operands.remove(0);
                operands.add(0, calculator.doComputation(left, right, computations.remove(0)));
            }
        }
        numberString.delete(0, numberString.length());
        numberString.append(operands.remove(0).toString());
        results.setText(numberString.toString());
    }
}
