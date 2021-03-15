/**
 * Convertible interface
 * @author Ryan Trepanier
 * @version 1.0
 */
package com.company.Model;

/**
 * This interface lists the methods that convertible calculators must have
 */
public interface Convertible {

    /**
     * This method converts the first binary number entered into decimal form
     * @param binaryVal the first binary number to be converted to decimal
     * @return the decimal form of the binary value
     */
    public int convert2Decimal(String binaryVal);

    /**
     * This method is used to convert answers back to binary after calculations are performed
     * @param val the result from whatever operation was performed
     * @return the result in binary
     */
    public String convert2Binary(long val);

    /**
     * This method converts decimal values back into hexadecimal after calculations are performed
     * @param val the decimal number to be converted to hexadecimal
     * @return the hexadecimal equivalent of the decimal value
     */
    public String convertDec2Hex(int val);

    /**
     * This method converts hexadecimal numbers into decimal form
     * @param theHex the hexadecimal number to be converted
     * @return the decimal equivalent of the hex number
     */
    public long convertHex2Dec(String theHex);
}
