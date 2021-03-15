/**
 * BigInteger Number class
 * @author Ryan Trepanier
 * @version 1.0
 */
package com.company.Model;

/**
 * Used for BigInteger objects
 */

import java.math.BigInteger;

/**
 * This class is used to create instances of BigIntegers
 */
public class BigIntegerNumber extends Number {

    /**
     * The String value of the BigInteger
     */
    private String bigInt;

    /**
     * This constructor makes a BigIntegerNumber
     * @param bigInt the String assigned to the field
     */
    public BigIntegerNumber(String bigInt) {
        this.bigInt = bigInt;
    }


    @Override
    public Number add(Number x) {
        return new BigIntegerNumber(new BigInteger(this.bigInt).add(new BigInteger(x.toString())).toString());
    }


    @Override
    public Number subtract(Number x) {
        return new BigIntegerNumber(new BigInteger(this.bigInt).subtract(new BigInteger(x.toString())).toString());
    }


    @Override
    public Number multiply(Number x) {
        return new BigIntegerNumber(new BigInteger(this.bigInt).multiply(new BigInteger(x.toString())).toString());
    }


    @Override
    public Number divide(Number x) {
        return new BigIntegerNumber(new BigInteger(this.bigInt).divide(new BigInteger(x.toString())).toString());
    }


    @Override
    public Number modulo(Number x) {
        return new BigIntegerNumber(new BigInteger(this.bigInt).mod(new BigInteger(x.toString())).toString());
    }

    @Override
    public long getDecimal() {
        return 0;
    }

    /**
     * This method provides a String representation of the field
     * @return the String value of the field
     */
    public String toString() {
        return this.bigInt;
    }
}
