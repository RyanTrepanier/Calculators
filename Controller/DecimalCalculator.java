/**
 * DecimalCalculator class
 * @author Ryan Trepanier
 * @version 1.0
 */
package com.company.Controller;

import com.company.Model.Number;

/**
 * This class implements all the basic methods in the
 * abstract class NumericCalculator
 */
public class DecimalCalculator extends NumericCalculator {


    @Override
    public Number add(Number x, Number y) {
        return x.add(y);
    }

    @Override
    public Number subtract(Number x, Number y) {
        return x.subtract(y);
    }

    @Override
    public Number multiply(Number x, Number y) {
        return x.multiply(y);
    }

    @Override
    public Number divide(Number x, Number y) {
        return x.divide(y);
    }

    @Override
    public Number modulo(Number x, Number y) {
        return x.modulo(y);
    }
}
