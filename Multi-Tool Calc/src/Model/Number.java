/**
 * Number abstract class
 * @author Ryan Trepanier
 * @version 1.0
 */
package Model;

import javax.swing.*;
import java.util.ArrayList;

/**
 * This class represents values of different types to be used as operands
 */
public class Number<T> {

    private boolean isInt, isDouble, isFloat, isLong, isHex, isBinary;

    private Integer myInt;

    private Double myDouble;

    private Float myFloat;

    private Long myLong;
    private String myHexString;
    private String myBinaryString;


    /**
     * Constructs Number object with a value of any type
     * @param theVal
     */
   public Number(final T theVal)
   {
       if (theVal instanceof Integer) {
           myInt = (Integer) theVal;
           isInt = true;
       } else if (theVal instanceof Double) {
           myDouble = (Double) theVal;
           isDouble = true;
       } else if (theVal instanceof Float) {
           myFloat = (Float) theVal;
           isFloat = true;
       } else if (theVal instanceof Long) {
           myLong = (Long) theVal;
           isLong = true;
       }
   }

    /**
     * Creates a binary Number with a value of type long
     * @param theNum the String representation of a binary number
     * @param isBinary controls the construction of a binary vs hex Number object
     */
    public Number(final String theNum, final boolean isBinary)
    {
        if (isBinary) {
            long decimal = 0;
            int n = 0;
            for (int i = theNum.length() - 1; i >= 0; i--) {
                if (theNum.charAt(i) == '1') {
                    decimal += Math.pow(2, n);
                }
                n++;
            }
            myBinaryString = theNum;
            myLong = decimal;
        } else {
            myLong = Long.parseLong(theNum);
            myHexString = theNum;
            isHex = true;
        }
    }

    public boolean isInt()
    {
        return isInt;
    }

    public boolean isDouble()
    {
        return isDouble;
    }

    public boolean isFloat()
    {
        return isFloat;
    }

    public boolean isLong()
    {
        return isLong;
    }

    public boolean isHex()
    {
        return isHex;
    }

    public boolean isBinary()
    {
        return isBinary;
    }

    public Integer getMyInt()
    {
        return myInt;
    }

    public Double getMyDouble()
    {
        return myDouble;
    }

    public Float getMyFloat()
    {
        return myFloat;
    }

    public Long getMyLong()
    {
        return myLong;
    }

    public String getMyHexString()
    {
        return myHexString;
    }

    public String getMyBinaryString()
    {
        return myBinaryString;
    }

    @Override
    public String toString()
    {
        String number;
        if (this.isInt) {
            number = Integer.toString(getMyInt());
        } else if (this.isDouble) {
            number = Double.toString(getMyDouble());
        } else if (this.isFloat) {
            number = Float.toString(getMyFloat());
        } else if (this.isLong) {
            number = Long.toString(getMyLong());
        } else if (this.isHex) {
            number = getMyHexString();
        } else {
            number = getMyBinaryString();
        }
        return number;
    }
}
