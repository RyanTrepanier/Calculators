/**
 * DownLoadUpload class
 * @author Ryan Trepanier
 * @version 1.0
 */
package com.company.Controller;

/**
 * This class performs functions of a download/upload time calculator
 */
public class DownloadUpload {

    /**
     * The size of the file in question
     */
    private double downloadUploadFileSize;

    /**
     * The unit type of the file-size in question
     */
    private int downloadUploadDataUnit;

    /**
     * The bandwidth speed
     */
    private double bandwidthSpeed;

    /**
     * The unit type for the bandwidth speed
     */
    private int bandwidthUnitType;

    /**
     * Default constructor
     */
    public DownloadUpload() {

    }

    /**
     * This constructor makes a DownloadUpload
     * @param theFileSize the size of the file
     * @param theDataUnit the data unit of the file-size
     * @param theSpeed the bandwidth speed
     * @param theSpeedUnit the data unit of the baandwidth speed
     */
    public DownloadUpload(double theFileSize, int theDataUnit, double theSpeed, int theSpeedUnit) {
        this.downloadUploadFileSize = theFileSize;
        this.downloadUploadDataUnit = theDataUnit;
        this.bandwidthSpeed = theSpeed;
        this.bandwidthUnitType = theSpeedUnit;
    }

    /**
     * This method accesses the file size
     * @return
     */
    public double getDownloadUploadFileSize() {
        return downloadUploadFileSize;
    }

    /**
     * This method sets the file size
     */
    public void setDownloadUploadFileSize(double downloadUploadFileSize) {
        this.downloadUploadFileSize = downloadUploadFileSize;
    }

    /**
     * This method accesses the file-size data unit
     * @return downloadUploadDataUnit the integer representing the user's choice
     */
    public int getDownloadUploadDataUnit() {
        return downloadUploadDataUnit;
    }

    /**
     * This method sets the data unit for the file
     */
    public void setDownloadUploadDataUnit(int downloadUploadDataUnit) {
        this.downloadUploadDataUnit = downloadUploadDataUnit;
    }

    /**
     * This method accesses the bandwidth speed
     * @return bandwidthSpeed the bandwidth speed
     */
    public double getBandwidthSpeed() {
        return bandwidthSpeed;
    }

    /**
     * This method sets the bandwidth speed
     */
    public void setBandwidthSpeed(double bandwidthSpeed) {
        this.bandwidthSpeed = bandwidthSpeed;
    }

    /**
     * This method accesses the bandwidth unit type
     * @return bandwidthUnitType the integer representing the user's choice
     */
    public int getBandwidthUnitType() {
        return bandwidthUnitType;
    }

    /**
     * This method sets the unit type for the bandwidth speed
     */
    public void setBandwidthUnitType(int bandwidthUnitType) {
        this.bandwidthUnitType = bandwidthUnitType;
    }

    /**
     * This method calculates the time it takes to download or upload a file
     * @param downloadUploadFileSize the file size
     * @param downloadUploadDataUnit the unit type of the file size
     * @param bandwidthSpeed the bandwidth speed
     * @param bandwidthUnitType the unit type for the bandwidth speed
     * @return time the time it takes to download or upload the file
     */
    public double calculateTime(double downloadUploadFileSize, int downloadUploadDataUnit,
                                double bandwidthSpeed, int bandwidthUnitType) {
        double time = downloadUploadFileSize / bandwidthSpeed;
        if (downloadUploadDataUnit == 1) {

                if (bandwidthUnitType == 1) {
                    time = bits();
                } else if (bandwidthUnitType == 2) {
                    time = Kbits();
                } else if (bandwidthUnitType == 3) {
                    time = Mbits();
                } else if (bandwidthUnitType == 4) {
                    time = Gbits();
                } else if (bandwidthUnitType == 5) {
                    time = Tbits();
                }
        } else if (downloadUploadDataUnit == 2) {
                if (bandwidthUnitType == 1) {
                    time = 8_000 * bits();
                } else if (bandwidthUnitType == 2) {
                    time = 8_000 * Kbits();
                } else if (bandwidthUnitType == 3) {
                    time = 8_000 * Mbits();
                } else if (bandwidthUnitType == 4) {
                    time = 8_000 * Gbits();
                } else if (bandwidthUnitType == 5) {
                    time = 8_000 * Tbits();
                }
        } else if (downloadUploadDataUnit == 3) {
            if (bandwidthUnitType == 1) {
                time = 8_000_000 * bits();
            } else if (bandwidthUnitType == 2) {
                time = 8_000_000 * Kbits();
            } else if (bandwidthUnitType == 3) {
                time = 8_000_000 * Mbits();
            } else if (bandwidthUnitType == 4) {
                time = 8_000_000 * Gbits();
            } else if (bandwidthUnitType == 5) {
                time = 8_000_000 * Tbits();
            }
        } else if (downloadUploadDataUnit == 4) {
            if (bandwidthUnitType == 1) {
                time = 8 * Math.pow(10, 9) * bits();
            } else if (bandwidthUnitType == 2) {
                time = 8 * Math.pow(10, 9) * Kbits();
            } else if (bandwidthUnitType == 3) {
                time = 8 * Math.pow(10, 9) * Mbits();
            } else if (bandwidthUnitType == 4) {
                time = 8 * Math.pow(10, 9) * Gbits();
            } else if (bandwidthUnitType == 5) {
                time = 8 * Math.pow(10, 9) * Tbits();
            }
        } else if (downloadUploadDataUnit == 5) {
            if (bandwidthUnitType == 1) {
                time = 8 * Math.pow(10, 12) * bits();
            } else if (bandwidthUnitType == 2) {
                time = 8 * Math.pow(10, 12) * Kbits();
            } else if (bandwidthUnitType == 3) {
                time = 8 * Math.pow(10, 12) * Mbits();
            } else if (bandwidthUnitType == 4) {
                time = 8 * Math.pow(10, 12) * Gbits();
            } else if (bandwidthUnitType == 5) {
                time = 8 * Math.pow(10, 12) * Tbits();
            }
        }
        return time;
    }

    /**
     * This method calculates the time for bits
     * @return the time it takes
     */
    public double bits() {
        return getDownloadUploadFileSize() / getBandwidthSpeed();
    }

    /**
     * This method calculates the time for kilobits
     * @return the time it takes
     */
    public double Kbits() {
        return getDownloadUploadFileSize() / (getBandwidthSpeed() * 1_000);
    }

    /**
     * This method calculates the time for megabits
     * @return the time it takes
     */
    public double Mbits() {
        return getDownloadUploadFileSize() / (getBandwidthSpeed() * 1_000_000);
    }

    /**
     * This method calculates the time for gigabits
     * @return the time it takes
     */
    public double Gbits() {
        return getDownloadUploadFileSize() / (getBandwidthSpeed() * Math.pow(10, 9));
    }

    /**
     * This method calculates the time for terabits
     * @return the time it takes
     */
    public double Tbits() {
        return getDownloadUploadFileSize() / (getBandwidthSpeed() * Math.pow(10, 12));
    }
}
