package Model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.*;
/**
 * This class sets up the main menu
 */
public class MyFrame extends JFrame implements ActionListener {
    JFrame menu;
    JRadioButton decimalCalculator;
    JRadioButton hexadecimalCalculator;
    JRadioButton binaryCalculator;
    JRadioButton dataUnitConverter;
    JButton submit = new JButton("Submit");

    public MyFrame() {
        // the main window
        menu = new JFrame("Ryan's Calculators");

        // available calculators w/submit button
        decimalCalculator = new JRadioButton("Decimal");
        hexadecimalCalculator = new JRadioButton("Hexadecimal");
        binaryCalculator = new JRadioButton("Binary");
        dataUnitConverter = new JRadioButton("Data Unit Converter");
        submit = new JButton("Submit");

        // grouping calculator options so only 1 can be selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(decimalCalculator);
        group.add(hexadecimalCalculator);
        group.add(binaryCalculator);
        group.add(dataUnitConverter);

        // setting size and placement of buttons
        decimalCalculator.setBounds(150, 100, 150, 20);
        hexadecimalCalculator.setBounds(150, 120, 150, 20);
        binaryCalculator.setBounds(150, 140, 150, 20);
        dataUnitConverter.setBounds(150, 160, 250, 20);
        submit.setBounds(130, 300, 150, 50);

        // adding buttons to the window
        menu.add(decimalCalculator);
        menu.add(hexadecimalCalculator);
        menu.add(binaryCalculator);
        menu.add(dataUnitConverter);
        menu.add(submit);

        // action listener for submit button
        submit.addActionListener(this);

        menu.setSize(400, 500);
        menu.setLayout(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (decimalCalculator.isSelected()) {
            DecimalView decimalView = new DecimalView();
        } else if (hexadecimalCalculator.isSelected()) {
            HexView hexView = new HexView();
        } else if (binaryCalculator.isSelected()) {
            BinaryView binaryView = new BinaryView();
        } else if (dataUnitConverter.isSelected()){
            BandwidthView bandwidthView = new BandwidthView();
        }
    }
}
