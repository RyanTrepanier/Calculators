/**
 * TCSS 305 PRGA#03-Trepanier_Ryan
 * ryantrep
 * @author Ryan Trepanier
 * @version 1.0
 */

package com.company.Controller;

/**
 * imports the Stack
 */

import com.company.Model.BinaryNumber;
import com.company.Model.Convertible;
import com.company.Model.Number;

import java.util.*;

/**
 * This class is contains binary numbers as data and has behaviour of a calculator.
 */
public class BinaryCalculator extends NumericCalculator implements Convertible {


    /**
     * This method adds two binary numbers
     * @param binaryVal the left side binary number
     * @param otherBinaryVal the right side binary number
     * @return the sum of the two numbers
     */
    public Number add(BinaryNumber binaryVal, BinaryNumber otherBinaryVal) {
        return binaryVal.add(otherBinaryVal);
    }

    /**
     * This method subtracts two binary numbers
     * @param binaryVal the left side binary number
     * @param otherBinaryVal the right side binary number
     * @return the difference between the numbers
     */
    public Number subtract(BinaryNumber binaryVal, BinaryNumber otherBinaryVal) {
        return binaryVal.subtract(otherBinaryVal);
    }

    /**
     * This method multiplies two binary numbers
     * @param binaryVal the left side binary number
     * @param otherBinaryVal the right side binary number
     * @return the product of the two numbers
     */
    public Number multiply(BinaryNumber binaryVal, BinaryNumber otherBinaryVal) {
        return binaryVal.multiply(otherBinaryVal);
    }

    /**
     * This method performs division between two binary numbers
     * @param binaryVal the left side binary number
     * @param otherBinaryVal the right side binary number
     * @return the quotient of the two numbers
     */
    public Number divide(BinaryNumber binaryVal, BinaryNumber otherBinaryVal) {
        return binaryVal.divide(otherBinaryVal);
    }

    @Override
    public int convert2Decimal(String binaryVal) {
        int decimal = 0;
        int n = 0;
        for (int i = binaryVal.length() - 1; i >= 0; i--) {
            if (binaryVal.charAt(i) == '1') {
                decimal += Math.pow(2, n);
            }
            n++;
        }
        return decimal;
    }

    @Override
    public String convert2Binary(long val) {
        StringBuilder sb = new StringBuilder();
        Stack<Long> stack = new Stack<Long>();
        while (val != 0) {
            long z = val % 2;
            stack.push(z);
            val /= 2;
        }
        while (!(stack.isEmpty())) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    @Override
    public String convertDec2Hex(int val) {
        return null;
    }

    @Override
    public long convertHex2Dec(String theHex) {
        return 0;
    }
}
