/**
 * HexViewTest class
 * @author Ryan Trepanier
 * @version 1.0
 */
package com.company.Controller;

/**
 * JUnit Test
 */
import com.company.Model.HexNumber;
import org.junit.jupiter.api.Test;

/**
 * JUnit Assertions library
 */
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests the methods of the HexCalculator class
 */
class HexViewTest {

    /**
     * This method tests the calculator's add method
     */
    @Test
    void add() {
        HexCalculator addTest = new HexCalculator();
        HexNumber left = new HexNumber("a");
        HexNumber right = new HexNumber("1f3");

        HexNumber expected = new HexNumber("1fd");
        HexNumber actual = (HexNumber) addTest.add(left, right);
        assertEquals(expected.toString(), actual.toString());
    }

    /**
     * This method tests the calculator's subtract method
     */
    @Test
    void subtract() {
        HexCalculator testSubtract = new HexCalculator();
        HexNumber left = new HexNumber("8ab1");
        HexNumber right = new HexNumber("b78");

        HexNumber sub = (HexNumber) testSubtract.subtract(left, right);
        HexNumber expected = new HexNumber("7f39");
        assertEquals(expected.toString(),sub.toString());
    }

    /**
     * This method tests the calculator's multiply method
     */
    @Test
    void multiply() {
        HexCalculator testMultiply = new HexCalculator();
        HexNumber left = new HexNumber("3f");
        HexNumber right = new HexNumber("2b");

        HexNumber product = (HexNumber) testMultiply.multiply(left, right);
        HexNumber expected = new HexNumber("a95");
        assertEquals(expected.toString(),product.toString());
    }

    /**
     * This method tests the calculator's divide method
     */
    @Test
    void division() {
        HexCalculator testDivide = new HexCalculator();
        HexNumber left = new HexNumber("a");
        HexNumber right = new HexNumber("2");

        HexNumber quotient = (HexNumber) testDivide.divide(left, right);
        HexNumber expected = new HexNumber("5");
        assertEquals(expected.toString(),quotient.toString());
    }

    /**
     * This method tests the calculator's modulo method
     */
    @Test
    void modulo() {
        HexCalculator testMod = new HexCalculator();
        HexNumber left = new HexNumber("a");
        HexNumber right = new HexNumber("2");

        HexNumber quotient = (HexNumber) testMod.modulo(left, right);
        HexNumber expected = new HexNumber("0");
        assertEquals(expected.toString(),quotient.toString());
    }

    /**
     * This method tests the calculator's conversion from hex to decimal
     */
    @Test
    void convertHex2Dec() {
        HexCalculator hex2Dec = new HexCalculator();
        String hexValue = "dad";
        long dec = hex2Dec.convertHex2Dec(hexValue);
        long expected = 3501;
        assertEquals(expected, dec);
    }

    /**
     * This method tests the calculator's conversion from decimal to hex
     */
    @Test
    void convertDec2Hex() {
        HexCalculator dec2Hex = new HexCalculator();
        long dec = 13;
        String hex = "D";
        String result = dec2Hex.convertDec2Hex(dec);
        assertEquals(result, hex);
    }
}