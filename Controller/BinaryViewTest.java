/**
 * BinaryViewTest class
 * @author Ryan Trepanier
 * @version 1.0
 */
package com.company.Controller;

/**
 * The JUnit Test API
 */
import com.company.Model.BinaryNumber;
import org.junit.jupiter.api.Test;

/**
 * JUnit Assertions library
 */
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class performs tests of all methods in the BinaryCalculator
 */
class BinaryViewTest {

    /**
     * This method tests the calculator's add function
     */
    @Test
    void add() {
        BinaryCalculator addTest = new BinaryCalculator();
        BinaryNumber left = new BinaryNumber("101");
        BinaryNumber right = new BinaryNumber("1011");
        
        BinaryNumber expected = new BinaryNumber("10000");
        BinaryNumber actual = (BinaryNumber) addTest.add(left, right);
        assertEquals(expected.toString(), actual.toString());
    }

    /**
     * This method tests the calculator's subtract function
     */
    @Test
    void subtract() {
        BinaryCalculator testSubtract = new BinaryCalculator();
        BinaryNumber left = new BinaryNumber("10");
        BinaryNumber right = new BinaryNumber("1");

        BinaryNumber sub = (BinaryNumber) testSubtract.subtract(left, right);
        BinaryNumber expected = new BinaryNumber("1");
        assertEquals(expected.toString(),sub.toString());
    }

    /**
     * This method tests the calculator's multiply function
     */
    @Test
    void multiply() {
        BinaryCalculator testMultiply = new BinaryCalculator();
        BinaryNumber left = new BinaryNumber("101010");
        BinaryNumber right = new BinaryNumber("111000");

        BinaryNumber product = (BinaryNumber) testMultiply.multiply(left, right);
        BinaryNumber expected = new BinaryNumber("100100110000");
        assertEquals(expected.toString(),product.toString());
    }

    /**
     * This method tests the calculator's divide function
     */
    @Test
    void division() {
        BinaryCalculator testDivide = new BinaryCalculator();
        BinaryNumber left = new BinaryNumber("11010");
        BinaryNumber right = new BinaryNumber("1101");

        BinaryNumber quotient = (BinaryNumber) testDivide.divide(left, right);
        BinaryNumber expected = new BinaryNumber("10");
        assertEquals(expected.toString(),quotient.toString());
    }

    /**
     * This method tests the calculator's modulo function
     */
    @Test
    void modulo() {
        BinaryCalculator testMod = new BinaryCalculator();
        BinaryNumber left = new BinaryNumber("11010");
        BinaryNumber right = new BinaryNumber("1101");

        BinaryNumber quotient = (BinaryNumber) testMod.modulo(left, right);
        BinaryNumber expected = new BinaryNumber("0");
        assertEquals(expected.toString(),quotient.toString());
    }

    /**
     * This method tests the calculator's conversion from binary to decimal function
     */
    @Test
    void convertBinary2Dec() {
        BinaryCalculator bin2Dec = new BinaryCalculator();
        String binaryValue = "1101";
        int dec = bin2Dec.convert2Decimal(binaryValue);
        int expected = 13;
        assertEquals(expected, dec);
    }

    /**
     * This method tests the calculator's conversion from decimal to binary function
     */
    @Test
    void convertDec2Binary() {
        BinaryCalculator dec2Bin = new BinaryCalculator();
        long dec = 13;
        BinaryNumber bin = new BinaryNumber(dec);
        String result = dec2Bin.convert2Binary(dec);
        assertEquals(result, "1101");
    }
}