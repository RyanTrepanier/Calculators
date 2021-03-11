package com.company.View;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractOperationsPanel {


    JPanel operations;
    JButton multiply;
    JButton divide;
    JButton add;
    JButton subtract;
    JButton equals;
    JButton clear;
    JTextField results = new JTextField();

    public JFrame operations() {

        JFrame newFrame = new JFrame();
        operations = new JPanel(new BorderLayout());

        multiply = new JButton("x");
        divide = new JButton("/");
        add = new JButton("+");
        subtract = new JButton("-");
        equals = new JButton("=");
        clear = new JButton("CLR");

        JPanel other = new JPanel();
        other.setLayout(new BoxLayout(other, BoxLayout.PAGE_AXIS));
        operations.add(other, BorderLayout.EAST);
        operations.add(results, BorderLayout.NORTH);
        results.setEditable(false);
        other.add(clear);
        other.add(multiply);
        other.add(divide);
        other.add(add);
        other.add(subtract);
        other.add(equals);
        newFrame.add(operations);
        newFrame.setSize(400, 400);
        newFrame.setVisible(true);
        return newFrame;
    }

}
