/**
 * HexNumber class
 * @author Ryan Trepanier
 * @version 1.0
 */
package com.company.Model;

/**
 * This class contains states and behaviours of HexNumber objects
 */
public class HexNumber extends Number {

    /**
     * The long value of the HexNumber
     */
    private long decimal;

    /**
     * This constructor makes a HexNumber object from a String value
     * @param theHex the String used to make a HexNumber
     */
    public HexNumber(String theHex) {
        super();
        String digits = "0123456789ABCDEF";
        theHex = theHex.toString().toUpperCase();
        long val = 0;
        for (int i = 0; i < theHex.length(); i++) {
            char c = theHex.charAt(i);
            long d = digits.indexOf(c);
            val = 16 * val + d;
        }
        this.decimal = val;
    }

    /**
     * This constructor makes a HexNumber object from a long value
     * @param hex the long value used to construct the HexNumber
     */
    public HexNumber(long hex) {
        super();
        this.decimal = hex;
    }

    @Override
    public long getDecimal() {
        return this.decimal;
    }

    @Override
    public Number add(Number x) {
        return new HexNumber(this.decimal + x.getDecimal());
    }

    @Override
    public Number subtract(Number x) {
        return new HexNumber(this.decimal - x.getDecimal());
    }

    @Override
    public Number multiply(Number x) {
        return new HexNumber(this.decimal * x.getDecimal());
    }

    @Override
    public Number divide(Number x) {
        return new HexNumber(this.decimal / x.getDecimal());
    }

    @Override
    public Number modulo(Number x) {
        return new HexNumber(this.decimal % x.getDecimal());
    }

    /**
     * This method converts the HexNumber field into a String
     * @return this.decimal as a String
     */
    public String toString() {
        return this.decimal + "";
    }
}
