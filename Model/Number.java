/**
 * Number abstract class
 * @author Ryan Trepanier
 * @version 1.0
 */
package com.company.Model;

/**
 * This abstract class declares several methods that all Numbers will need to implement
 */
public abstract class Number {

    /**
     * Method to access decimal field
     * @return long decimal value
     */
    public abstract long getDecimal();

    /**
     * Method to add two Numbers
     * @param x the other Number
     * @return Number sum
     */
    public abstract Number add(Number x);

    /**
     * Method to subtract two Numbers
     * @param x the other Number
     * @return Number difference
     */
    public abstract Number subtract(Number x);

    /**
     * Method to multiply two Numbers
     * @param x the other Number
     * @return Number product
     */
    public abstract Number multiply(Number x);

    /**
     * Method to divide two Numbers
     * @param x the other Number
     * @return Number quotient
     */
    public abstract Number divide(Number x);

    /**
     * Method to perform modulo operation on two Numbers
     * @param x the other Number
     * @return Number remainder
     */
    public abstract Number modulo(Number x);
}
