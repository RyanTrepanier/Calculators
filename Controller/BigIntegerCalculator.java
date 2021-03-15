/**
 * BigInteger Calculator class
 * @author Ryan Trepanier
 * @version 1.0
 */
package com.company.Controller;

import com.company.Model.Number;

/**
 * This class contains calculator methods used on BigInteger objects
 */
public class BigIntegerCalculator extends NumericCalculator {

    /**
     * This method adds two Number objects together
     * @param x the first Number
     * @param y the second Number
     * @return the sum Number
     */
    @Override
    public Number add(Number x, Number y) {
        return x.add(y);
    }

    /**
     * This method subtracts two Number objects
     * @param x the first Number
     * @param y the second Number
     * @return the difference in Number
     */
    @Override
    public Number subtract(Number x, Number y) {
        return x.subtract(y);
    }

    /**
     * This method multiplies two Number objects
     * @param x the first Number
     * @param y the second Number
     * @return the product as a Number
     */
    @Override
    public Number multiply(Number x, Number y) {
        return x.multiply(y);
    }

    /**
     * This method divides two Numbers
     * @param x the first Number
     * @param y the second Number
     * @return the quotient Number
     */
    @Override
    public Number divide(Number x, Number y) {
        return x.divide(y);
    }

    /**
     * This method performs the modulus operation on two Numbers
     * @param x the first Number
     * @param y the second Number
     * @return the remainder Number
     */
    @Override
    public Number modulo(Number x, Number y) {
        return x.modulo(y);
    }
}
