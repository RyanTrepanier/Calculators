/**
 * DecimalNumber class
 * @author Ryan Trepanier
 * @version 1.0
 */
package com.company.Model;

/**
 * This class contains states and behaviours of a DecimalNumber object
 */
public class DecimalNumber extends Number {

    /**
     * The value of a DecimalNumber object
     */
    private double number;

    /**
     * This constructor makes a DecimalNumber object
     * @param aNumber the value to be assigned to the object's field
     */
    public DecimalNumber(double aNumber) {
       this.number = aNumber;
    }

    @Override
    public Number add(Number x) {
        return new DecimalNumber(this.number + ((DecimalNumber)x).getDouble());
    }

    @Override
    public Number subtract(Number x) {
        return new DecimalNumber(this.number - ((DecimalNumber)x).getDouble());
    }

    @Override
    public Number multiply(Number x) {
        return new DecimalNumber(this.number * ((DecimalNumber)x).getDouble());
    }

    @Override
    public Number divide(Number x) {
        return new DecimalNumber(this.number / ((DecimalNumber)x).getDouble());
    }

    @Override
    public Number modulo(Number x) {
        return new DecimalNumber(this.number % ((DecimalNumber)x).getDouble());
    }

    //We will not use this method
    @Override
    public long getDecimal() {
        return Math.round(this.number);
    }

    /**
     * This method accesses the object's private field
     * @return this.number the object's field
     */
    public double getDouble() { return this.number;}

    public String toString() {
        return this.number + "";
    }
}
