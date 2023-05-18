package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;

public class Calculator {


    private Number add(final Number theLeft, final Number theRight)
    {
        Number result;
        if (theLeft.isInt()) {
            result = new Number(theLeft.getMyInt() + theRight.getMyInt());
        } else if (theLeft.isDouble()) {
            result = new Number(theLeft.getMyDouble() + theRight.getMyDouble());
        } else if (theLeft.isFloat()) {
            result = new Number(theLeft.getMyFloat() + theRight.getMyFloat());
        } else {
            result = new Number(theLeft.getMyLong() + theRight.getMyLong());
        }
        return result;
    }

    private Number subtract(final Number theLeft, final Number theRight)
    {
        Number result;
        if (theLeft.isInt()) {
            result = new Number(theLeft.getMyInt() - theRight.getMyInt());
        } else if (theLeft.isDouble()) {
            result = new Number(theLeft.getMyDouble() - theRight.getMyDouble());
        } else if (theLeft.isFloat()) {
            result = new Number(theLeft.getMyFloat() - theRight.getMyFloat());
        } else {
            result = new Number(theLeft.getMyLong() - theRight.getMyLong());
        }
        return result;
    }

    private Number multiply(final Number theLeft, final Number theRight)
    {
        Number result;
        if (theLeft.isInt()) {
            result = new Number(theLeft.getMyInt() * theRight.getMyInt());
        } else if (theLeft.isDouble()) {
            result = new Number(theLeft.getMyDouble() * theRight.getMyDouble());
        } else if (theLeft.isFloat()) {
            result = new Number(theLeft.getMyFloat() * theRight.getMyFloat());
        } else {
            result = new Number(theLeft.getMyLong() * theRight.getMyLong());
        }
        return result;
    }

    private Number divide(final Number theLeft, final Number theRight)
    {
        Number result;
        if (theLeft.isInt()) {
            if (theLeft.getMyInt() % theRight.getMyInt() != 0) {
                result = new Number(Float.parseFloat(theLeft.getMyInt().toString()) /
                                           Float.parseFloat(theRight.getMyInt().toString()));
            } else {
                result = new Number(theLeft.getMyInt() / theRight.getMyInt());
            }
        } else if (theLeft.isDouble()) {
            result = new Number(theLeft.getMyDouble() / theRight.getMyDouble());
        } else if (theLeft.isFloat()) {
            result = new Number(theLeft.getMyFloat() / theRight.getMyFloat());
        } else {
            result = new Number(theLeft.getMyLong() / theRight.getMyLong());
        }
        return result;
    }

    public Number doComputation(final Number theLeft, final Number theRight, final JButton theOperator)
    {
        Number result = new Number(0);
        switch (theOperator.getText()) {
            case "+": result = add(theLeft, theRight);
                      break;
            case "-": result = subtract(theLeft, theRight);
                      break;
            case "x": result = multiply(theLeft, theRight);
                      break;
            case "/": result = divide(theLeft, theRight);
                      break;
            case "Hex -> Decimal": result = convertHexToDecimal(theLeft);
                      break;
            case "Decimal -> Hex": result = convertDecimalToHex(theLeft);
                      break;
            case "Binary -> Decimal": result = convertBinaryToDecimal(theLeft);
                      break;
            case "Decimal -> Binary": result = convertDecimalToBinary(theLeft);
                      break;
            default:  break;
        }
        return result;
    }

    private Number convertHexToDecimal(final Number theHexString)
    {
        String digits = "0123456789ABCDEF";
        StringBuilder temp = new StringBuilder();
        temp.append(theHexString.toString().toUpperCase());
        StringBuilder hex = temp.reverse();
        Integer val = 0;
        int base = 1;
        for (int i = 0; i < hex.length(); i++) {
            val +=  base * digits.indexOf(hex.charAt(i));
            base *= 16;
        }
        return new Number(val);
    }

    private Number convertDecimalToHex(final Number theDecimalNum)
    {
        String digits = "0123456789ABCDEF";
        StringBuilder hexBuilder = new StringBuilder();
        int val = Integer.parseInt(theDecimalNum.toString());
        ArrayList<Character> temp = new ArrayList<>();
        while (val > 0) {
            int remainder = val % 16;
            val /= 16;
            temp.add(0, digits.charAt(remainder));
        }
        for (Character hex: temp) {
            hexBuilder.append(hex);
        }
        return new Number(hexBuilder.toString(), false);
    }

    private Number convertDecimalToBinary(final Number theDecimalNum)
    {
        StringBuilder sb = new StringBuilder();
        Stack<Long> stack = new Stack<>();
        long val = theDecimalNum.getMyLong();
        while (val != 0) {
            long z = val % 2;
            stack.push(z);
            val /= 2;
        }
        while (!(stack.isEmpty())) {
            sb.append(stack.pop());
        }
        return new Number(sb.toString(), true);
    }

    private Number convertBinaryToDecimal(final Number theBinaryNum)
    {
        int decimal = 0;
        int n = 0;
        String binary = theBinaryNum.toString();
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += Math.pow(2, n);
            }
            n++;
        }
        return new Number(decimal);
    }
}
