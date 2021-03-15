/**
 * NumericCalculator abstract class
 * @author Ryan Trepanier
 * @version 1.0
 */
package com.company.Controller;

import com.company.Model.Number;

/**
 * This abstract class contains methods that all calculators of this type must implement
 */
public abstract class NumericCalculator {

    /**
     * This method adds two Numbers
     * @param x first Number
     * @param y second Number
     * @return Number sum
     */
    public Number add(Number x, Number y) {
        return x.add(y);
    }

    /**
     * This method subtracts two Numbers
     * @param x first Number
     * @param y second Number
     * @return Number difference
     */
    public Number subtract(Number x, Number y) {
        return x.subtract(y);
    }

    /**
     * This method multiplies two Numbers
     * @param x first Number
     * @param y second Number
     * @return Number product
     */
    public Number multiply(Number x, Number y) {
        return x.multiply(y);
    }

    /**
     * This method divides two Numbers
     * @param x first Number
     * @param y second Number
     * @return Number quotient
     */
    public Number divide(Number x, Number y) {
        return x.divide(y);
    }

    /**
     * This method mods two Numbers
     * @param x first Number
     * @param y second Number
     * @return Number remainder
     */
    public Number modulo(Number x, Number y) {
        return x.modulo(y);
    }

}
