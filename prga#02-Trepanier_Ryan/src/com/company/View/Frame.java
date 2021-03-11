package com.company.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends AbstractOperationsPanel implements ActionListener {

    JFrame frame;
    JPanel panel;
    JLabel label;
    JRadioButton binary;
    JRadioButton hex;
    JRadioButton decimal;
    JRadioButton bigInt;
    JRadioButton bandwidth;
    JButton submit;
    ButtonGroup calculators;

    public Frame() {
        frame = new JFrame("Calculator");
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        label = new JLabel("Choose your calculator: ");
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.setPreferredSize(new Dimension(150, 200));
        panel.add(label);

        binary = new JRadioButton("Binary");
        hex = new JRadioButton("Hexadecimal");
        decimal = new JRadioButton("Decimal");
        bigInt = new JRadioButton("BigInteger");
        bandwidth = new JRadioButton("Bandwidth");

        binary.addActionListener(this);
        hex.addActionListener(this);
        decimal.addActionListener(this);
        bigInt.addActionListener(this);
        bandwidth.addActionListener(this);

        calculators = new ButtonGroup();
        calculators.add(binary);
        calculators.add(hex);
        calculators.add(decimal);
        calculators.add(bigInt);
        calculators.add(bandwidth);

        panel.add(binary);
        panel.add(hex);
        panel.add(decimal);
        panel.add(bigInt);
        panel.add(bandwidth);

        submit = new JButton("Submit");
        submit.addActionListener(this);
        frame.add(submit, BorderLayout.SOUTH);

        frame.add(panel, BorderLayout.WEST);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {


            if (binary.isSelected()) {
                BinaryView binaryView = new BinaryView();

//                newFrame.setSize(400, 400);
//                newFrame.setTitle("Binary Calculator");
//                newFrame.setVisible(true);
            } else if (hex.isSelected()) {
                HexView hexView = new HexView();
                //DecFrame decFrame = new DecFrame();

            } else if (decimal.isSelected()) {
                DecimalView decimalView = new DecimalView();
//                newFrame = operations();
//                newFrame.setSize(400, 400);
//                newFrame.setTitle("Decimal Calculator");
//                newFrame.setVisible(true);
            } else if (bigInt.isSelected()) {
                BigIntView bigIntView = new BigIntView();
//                newFrame = operations();
//                newFrame.setSize(400, 400);
//                newFrame.setTitle("BigInteger Calculator");
//                newFrame.setVisible(true);
            } else if (bandwidth.isSelected()) {
                JFrame other = new JFrame();
                other.setTitle("Bandwidth Calculator");
                other.setSize(400, 400);
                other.setVisible(true);
            }
        }
    }
}
