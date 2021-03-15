/**
 * BinaryNumber class
 * @author Ryan Trepanier
 * @version 1.0
 */
package com.company.Model;

/**
 * This class has states and behaviours of BinaryNumber objects
 */
public class BinaryNumber extends Number {

    /**
     * This field represents the value of a BinaryNumber
     */
    private long decimal;

    /**
     * This constructor makes a BinaryNumber
     * @param bin1 contains 1's and 0's
     */
    public BinaryNumber(String bin1) {
        super();
        long decimal = 0;
        int n = 0;
        for (int i = bin1.length() - 1; i >= 0; i--) {
            if (bin1.charAt(i) == '1') {
                decimal += Math.pow(2, n);
            }
            n++;
        }
        this.decimal = decimal;
    }

    /**
     * This constructor makes a BinaryNumber
     * @param decimal contains other numbers
     */
    public BinaryNumber(long decimal) {
        super();
        this.decimal = decimal;
    }

    @Override
    public Number add(Number x) {
        return new BinaryNumber(this.decimal + x.getDecimal());
    }

    @Override
    public Number subtract(Number x) {
        return new BinaryNumber(this.decimal - x.getDecimal());
    }

    @Override
    public Number multiply(Number x) {
        return new BinaryNumber(this.decimal * x.getDecimal());
    }

    @Override
    public Number divide(Number x) {
        return new BinaryNumber(this.decimal / x.getDecimal());
    }

    @Override
    public Number modulo(Number x) {
        return new BinaryNumber(this.decimal % x.getDecimal());
    }

    /**
     * This method accesses the private field
     * @return this.decimal the value of the field
     */
    public long getDecimal() {
        return this.decimal;
    }

    /**
     * This method creates a String representation of the field
     * @return "this.decimal"
     */
    public String toString() {
        return this.decimal + "";
    }
}
