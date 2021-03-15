/**
 * TCSS 305 PRGA#03-Trepanier_Ryan
 * ryantrep
 * @author Ryan Trepanier
 * @version 1.0
 */

package com.company.Controller;

/**
 * The Scanner that reads input
 */
import com.company.Model.Number;
import com.company.View.*;

import java.util.Scanner;

/**
 * This class is the driver of the Object-Oriented Calculator program
 */
public class Main {

    /**
     * Error text - red
     */
    public static final String ERROR = "\u001B[31m";

    /**
     * Normal text - blue
     */
    public static final String TEXT = "\u001B[34m";



    public static void main(String[] args) {

        Frame calcFrame = new Frame();
        Scanner console = new Scanner(System.in);
        printIntroduction();
        System.out.println(TEXT + "1) Binary");
        System.out.println(TEXT + "2) Hexadecimal");
        System.out.println(TEXT + "3) Bandwidth");
        System.out.println(TEXT + "4) Test Mode");
        System.out.println(TEXT + "5) Decimal");
        System.out.println(TEXT + "6) BigInteger");
        System.out.println(TEXT + "-1) Quit");
        System.out.print(TEXT + "Make your choice: ");
        boolean repeat = true;
        NumericCalculator calc = null;
        Number leftValue = null;
        Number rightValue = null;
        char operator = '0';
        int operation = 0;
        while (repeat) {

            try {

                int calcChoice = Validation.validateCalculatorMenu(console);
                switch (calcChoice) {
                    case -1:
                        repeat = false;
                        break;
                    case 1:
                        BinaryView viewBin = new BinaryView();
                        viewBin.show();
                        break;
                    case 2:
                        HexView viewHex = new HexView();
                        viewHex.show();
                        break;
                    case 3:
                        System.out.println(TEXT + "Welcome to the Bandwidth Calculator!");
                        System.out.println(TEXT + "Below is a list of functions you can perform.");
                        System.out.println();
                        System.out.println(TEXT + "1) Data Unit Converter");
                        System.out.println(TEXT + "2) Download/Upload Time Calculator");
                        System.out.println(TEXT + "3) Website Bandwidth Calculator");
                        System.out.println(TEXT + "4) Hosting Bandwidth Converter");
                        System.out.println();
                        int function = Validation.validateBandwidthCalcChoice(console);
                        switch (function) {
                            case -1:
                                repeat = false;
                                break;
                            case 1:
                                System.out.print(TEXT + "Enter a number for a file size: ");
                                double size = Validation.validateDouble(console);
                                if (size == -1) {
                                    repeat = false;
                                    break;
                                }
                                System.out.println(TEXT + "1) bits");
                                System.out.println(TEXT + "2) kilobits");
                                System.out.println(TEXT + "3) megabits");
                                System.out.println(TEXT + "4) gigabits");
                                System.out.println(TEXT + "5) terabits");
                                System.out.println(TEXT + "6) Bytes");
                                System.out.println(TEXT + "7) Kilobytes");
                                System.out.println(TEXT + "8) Megabytes");
                                System.out.println(TEXT + "9) Gigabytes");
                                System.out.println(TEXT + "10) Terabytes");
                                System.out.print(TEXT + "Now pick a unit type: ");
                                int unitType = Validation.validateDataUnitConverterFileType(console);
                                System.out.println();
                                switch (unitType) {
                                    case -1:
                                        repeat = false;
                                        break;
                                    case 1:
                                        System.out.println(TEXT + size + " bits is equivalent to:");
                                        System.out.println(TEXT + size * .001 + " kilobits");
                                        System.out.println(TEXT + size * .000001 + " megabits");
                                        System.out.println(TEXT + size * .000000001 + " gigabits");
                                        System.out.println(TEXT + size * .000000000001 + " terabits");
                                        System.out.println(TEXT + size * .125 + " Bytes");
                                        System.out.println(TEXT + size * .000125 + " Kilobytes");
                                        System.out.println(TEXT + size * .000000125 + " Megabytes");
                                        System.out.println(TEXT + size * .000000000125 + " Gigabytes");
                                        System.out.println(TEXT + size * .000000000000125 + " Terabytes");
                                        break;
                                    case 2:
                                        System.out.println(TEXT + size + " kilobits is equivalent to:");
                                        System.out.println(TEXT + size * 1000 + " bits");
                                        System.out.println(TEXT + size * .001 + " megabits");
                                        System.out.println(TEXT + size * .000001 + " gigabits");
                                        System.out.println(TEXT + size * .000000001 + " terabits");
                                        System.out.println(TEXT + size * 125 + " Bytes");
                                        System.out.println(TEXT + size * .125 + " Kilobytes");
                                        System.out.println(TEXT + size * .000125 + " Megabytes");
                                        System.out.println(TEXT + size * .000000125 + " Gigabytes");
                                        System.out.println(TEXT + size * .000000000125 + " Terabytes");
                                        break;
                                    case 3:
                                        System.out.println(TEXT + size + " megabits is equivalent to:");
                                        System.out.println(TEXT + size * 1_000_000 + " bits");
                                        System.out.println(TEXT + size * 1_000 + " kilobits");
                                        System.out.println(TEXT + size * .001 + " gigabits");
                                        System.out.println(TEXT + size * .000001 + " terabits");
                                        System.out.println(TEXT + size * 125_000 + " Bytes");
                                        System.out.println(TEXT + size * 125 + " Kilobytes");
                                        System.out.println(TEXT + size * .125 + " Megabytes");
                                        System.out.println(TEXT + size * .000125 + " Gigabytes");
                                        System.out.println(TEXT + size * .000000125 + " Terabytes");
                                        break;
                                    case 4:
                                        System.out.println(TEXT + size + " gigabits is equivalent to:");
                                        System.out.println(TEXT + size * 1_000_000_000 + " bits");
                                        System.out.println(TEXT + size * 100_000 + " kilobits");
                                        System.out.println(TEXT + size * 1_000 + " megabits");
                                        System.out.println(TEXT + size * .001 + " terabits");
                                        System.out.println(TEXT + size * 125_000_000 + " Bytes");
                                        System.out.println(TEXT + size * 125_000 + " Kilobytes");
                                        System.out.println(TEXT + size * 125 + " Megabytes");
                                        System.out.println(TEXT + size * .125 + " Gigabytes");
                                        System.out.println(TEXT + size * .000125 + " Terabytes");
                                        break;
                                    case 5:
                                        System.out.println(TEXT + size + " terabits is equivalent to:");
                                        System.out.println(TEXT + size * Math.pow(10, 12) + " bits");
                                        System.out.println(TEXT + size * 1_000_000_000 + " kilobits");
                                        System.out.println(TEXT + size * 1_000_000 + " megabits");
                                        System.out.println(TEXT + size * 1_000 + " gigabits");
                                        System.out.println(TEXT + size * 1.25 * Math.pow(10, 11) + " Bytes");
                                        System.out.println(TEXT + size * 125_000_000 + " Kilobytes");
                                        System.out.println(TEXT + size * 125_000 + " Megabytes");
                                        System.out.println(TEXT + size * 125 + " Gigabytes");
                                        System.out.println(TEXT + size * .125 + " Terabytes");
                                        break;
                                    case 6:
                                        System.out.println(TEXT + size + " Bytes is equivalent to:");
                                        System.out.println(TEXT + size * 8 + " bits");
                                        System.out.println(TEXT + size * .008 + " kilobits");
                                        System.out.println(TEXT + size * .000008 + " megabits");
                                        System.out.println(TEXT + size * .000000008 + " gigabits");
                                        System.out.println(TEXT + size * .000000000008 + " terabits");
                                        System.out.println(TEXT + size * .001 + " Kilobytes");
                                        System.out.println(TEXT + size * .000001 + " Megabytes");
                                        System.out.println(TEXT + size * .000000001 + " Gigabytes");
                                        System.out.println(TEXT + size * .000000000001 + " Terabytes");
                                        break;
                                    case 7:
                                        System.out.println(TEXT + size + " Kilobytes is equivalent to:");
                                        System.out.println(TEXT + size * 8_000 + " bits");
                                        System.out.println(TEXT + size * 8 + " kilobits");
                                        System.out.println(TEXT + size * .008 + " megabits");
                                        System.out.println(TEXT + size * .000008 + " gigabits");
                                        System.out.println(TEXT + size * .000000008 + " terabits");
                                        System.out.println(TEXT + size * 1_000 + " Bytes");
                                        System.out.println(TEXT + size * .001 + " Megabytes");
                                        System.out.println(TEXT + size * .000001 + " Gigabytes");
                                        System.out.println(TEXT + size * .000000001 + " Terabytes");
                                        break;
                                    case 8:
                                        System.out.println(TEXT + size + " Megabytes is equivalent to:");
                                        System.out.println(TEXT + size * 8_000 + " kilobits");
                                        System.out.println(TEXT + size * 8 + " megabits");
                                        System.out.println(TEXT + size * .008 + " gigabits");
                                        System.out.println(TEXT + size * .000008 + " terabits");
                                        System.out.println(TEXT + size * 1_000_000 + " Bytes");
                                        System.out.println(TEXT + size * 1_000 + " Kilobytes");
                                        System.out.println(TEXT + size * .001 + " Gigabytes");
                                        System.out.println(TEXT + size * .000001 + " Terabytes");
                                        break;
                                    case 9:
                                        System.out.println(TEXT + size + " Gigabytes is equivalent to:");
                                        System.out.println(TEXT + size * 8 * Math.pow(10, 9) + " bits");
                                        System.out.println(TEXT + size * 8_000_000 + " kilobits");
                                        System.out.println(TEXT + size * 8_000 + " megabits");
                                        System.out.println(TEXT + size * 8 + " gigabits");
                                        System.out.println(TEXT + size * .008 + " terabits");
                                        System.out.println(TEXT + size * Math.pow(10, 9) + " Bytes");
                                        System.out.println(TEXT + size * 1_000_000 + " Kilobytes");
                                        System.out.println(TEXT + size * 1_000 + " Megabytes");
                                        System.out.println(TEXT + size * .001 + " Terabytes");
                                        break;
                                    case 10:
                                        System.out.println(TEXT + size + " Terabytes is equivalent to:");
                                        System.out.println(TEXT + size * 8 * Math.pow(10, 12) + " bits");
                                        System.out.println(TEXT + size * 8 * Math.pow(10, 9) + " kilobits");
                                        System.out.println(TEXT + size * 8_000_000 + " megabits");
                                        System.out.println(TEXT + size * 8_000 + " gigabits");
                                        System.out.println(TEXT + size * 8 + " terabits");
                                        System.out.println(TEXT + size * Math.pow(10, 12) + " Bytes");
                                        System.out.println(TEXT + size * Math.pow(10, 9) + " Kilobytes");
                                        System.out.println(TEXT + size * 1_000_000 + " Megabytes");
                                        System.out.println(TEXT + size * 1_000 + " Gigabytes");
                                        break;
                                    default:
                                        System.out.println(ERROR + "Not a valid choice, please try again.");
                                }
                            case 2:
                                System.out.print(TEXT + "Enter a number for the file size: ");
                                double downloadUploadFileSize = Validation.validateDouble(console);
                                System.out.print(TEXT + "\nNow select which unit type you want to work with:\n 1)Bytes\n2)Kilobytes" +
                                        "\n3)Megabytes \n4)Gigabytes \n5)Terabytes): ");
                                int downloadUploadDataUnit = Validation.validate1Through5(console);
                                System.out.print(TEXT + "\nNow enter the bandwidth speed: ");
                                double bandwidthSpeed = Validation.validateDouble(console);
                                System.out.print(TEXT + "\nNow choose one of the following for your units\n1)bit/s\n2)Kbit/s\n3)Mbit/s" +
                                        "\n4)Gbit/s \n5)Tbit/s): ");
                                int bandwidthUnitType = Validation.validate1Through5(console);
                                DownloadUpload DU = new DownloadUpload(downloadUploadFileSize, downloadUploadDataUnit,
                                        bandwidthSpeed, bandwidthUnitType);
                                System.out.println(TEXT + "\nThe download/upload time is " + DU.calculateTime(downloadUploadFileSize,
                                        downloadUploadDataUnit,
                                        bandwidthSpeed,
                                        bandwidthUnitType) + " seconds");
                                break;
                            case 3:
                                System.out.println(TEXT + "1)Per Second\n2)Per Minute\n3)Per Hour" +
                                        TEXT + "\n4)Per Day\n5)Per Week\n6)Per Month\n7)Per Year");
                                System.out.print(TEXT + "Choose the time period you want to work with: ");
                                int perTimePeriod = Validation.validateTimePeriod(console);
                                System.out.print(TEXT + "Enter the number of page views you get during that time: ");
                                double pageViews = Validation.validateDouble(console);
                                System.out.println(TEXT + "1)Bytes\n2)Kilobytes\n3)Megabytes\n4)Gigabytes" +
                                        TEXT + "\n5)Terabytes");
                                System.out.print(TEXT + "Now choose the unit for your page size: ");
                                int pageSizeUnit = Validation.validateCalculatorMenu(console);
                                System.out.print(TEXT + "Now enter the page size: ");
                                double pageSize = Validation.validateDouble(console);
                                System.out.print(TEXT + "\nFinally, enter a number for your redundancy factor: ");
                                int redundancy = (int) Validation.validateDouble(console);
                                WebsiteBandwidth wb = new WebsiteBandwidth(perTimePeriod, pageViews, pageSizeUnit, pageSize, redundancy);
                                System.out.println(TEXT + "Bandwidth needed is " + wb.calculatePerSecond() + " Mbits/s or " +
                                        wb.calculatePerMonth() + " GB per month");
                                break;
                        }
                    case 4:
                        DownloadUpload theDU = new DownloadUpload(30.0, 3, 10.0, 3);
                        System.out.println(TEXT + "Download/Upload speed is " + theDU.calculateTime(30.0, 3, 10.0, 3));
                        WebsiteBandwidth theWB = new WebsiteBandwidth(3, 1000, 3, 50, 2);
                        System.out.println(TEXT + "Bandwidth needed is " + theWB.calculatePerSecond() + " Mbits/s or " +
                                theWB.calculatePerMonth() + " GB per month");
                        break;
                    case 5:
                        DecimalView decView = new DecimalView();
                        decView.show();
                        break;
                    case 6:
                        BigIntView bigView = new BigIntView();
                        bigView.show();
                        break;
                    default:
                        repeat = false;
                        break;

                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(ERROR + "Error, please try again!");
            }
        }
    }


        /**
        * Simple method to prevent the main method from being any bigger than it already is.
        */
        public static void printIntroduction() {
            System.out.println(TEXT + "This program allows you to perform basic calculations");
            System.out.println(TEXT + "and conversions between 2 different number systems,");
            System.out.println(TEXT + "hexadecimal and binary, and even includes a bandwidth calculator!");
            System.out.println();
        }
}
