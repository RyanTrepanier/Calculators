/**
 * TCSS 305 PRGA#03-Trepanier_Ryan
 * ryantrep
 * @author Ryan Trepanier
 * @version 1.0
 */

package com.company.Controller;


import com.company.Model.Convertible;
import com.company.Model.HexNumber;
import com.company.Model.Number;

/**
 * This class contains two hexadecimal fields and has behaviors of a calculator/ converter
 */
public class HexCalculator extends NumericCalculator implements Convertible {

    /**
     * This method adds two binary numbers
     * @param hexVal the left side binary number
     * @param otherHexVal the right side binary number
     * @return the sum of the two numbers
     */
    public Number add(HexNumber hexVal, HexNumber otherHexVal) {
        return hexVal.add(otherHexVal);
    }

    /**
     * This method subtracts two binary numbers
     * @param hexVal the left side binary number
     * @param otherHexVal the right side binary number
     * @return the difference between the numbers
     */
    public Number subtract(HexNumber hexVal, HexNumber otherHexVal) {
        return hexVal.subtract(otherHexVal);
    }

    /**
     * This method multiplies two binary numbers
     * @param hexVal the left side binary number
     * @param otherHexVal the right side binary number
     * @return the product of the two numbers
     */
    public Number multiply(HexNumber hexVal, HexNumber otherHexVal) {
        return hexVal.multiply(otherHexVal);
    }

    /**
     * This method performs division between two binary numbers
     * @param hexVal the left side binary number
     * @param otherHexVal the right side binary number
     * @return the quotient of the two numbers
     */
    public Number divide(HexNumber hexVal, HexNumber otherHexVal) {
        return hexVal.divide(otherHexVal);
    }

    @Override
    public int convert2Decimal(String binaryVal) {
        return 0;
    }

    @Override
    public String convert2Binary(long val) {
        return null;
    }

    @Override
    public String convertDec2Hex(int val) {
        return null;
    }

    /**
     * This method converts hexadecimal numbers into decimal form
     * @param theHex the hexadecimal number to be converted
     * @return the decimal equivalent of the hex number
     */
    @Override
    public long convertHex2Dec(String theHex) {
        String digits = "0123456789ABCDEF";
        theHex = theHex.toString().toUpperCase();
        long val = 0;
        for (int i = 0; i < theHex.length(); i++) {
            char c = theHex.charAt(i);
            long d = digits.indexOf(c);
            val = 16 * val + d;
        }
        return val;
    }

    /**
     * This method converts decimal values back into hexadecimal after calculations are performed
     * @param val the decimal number to be converted to hexadecimal
     * @return the hexadecimal equivalent of the decimal value
     */
    public String convertDec2Hex(long val) {
        int remainder = 0;
        String result = "";
        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(val > 0) {
            remainder = (int) val % 16;
            result = hex[remainder] + result;
            val = val / 16;
        }
        return result;
    }

    public double getDecimal() {
        return 0;
    }
}
