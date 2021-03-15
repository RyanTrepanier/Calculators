package com.company.Controller;

public class WebsiteBandwidth {

    private int perTimePeriod;

    private double pageViews;

    private int pageSizeUnit;

    private double pageSize;

    private int redundancy;

    public WebsiteBandwidth() {

    }

    public WebsiteBandwidth(int theTimePeriod, double thePageViews, int thePageUnit,
                            double theSize, int theRedundancy) {
        this.perTimePeriod = theTimePeriod;
        this.pageViews = thePageViews;
        this.pageSizeUnit = thePageUnit;
        this.pageSize = theSize;
        this.redundancy = theRedundancy;
    }

    public int getPerTimePeriod() {
        return perTimePeriod;
    }

    public void setPerTimePeriod(int perTimePeriod) {
        this.perTimePeriod = perTimePeriod;
    }

    public double getPageViews() {
        return pageViews;
    }

    public void setPageViews(double pageViews) {
        this.pageViews = pageViews;
    }

    public int getPageSizeUnit() {
        return pageSizeUnit;
    }

    public void setPageSizeUnit(int pageSizeUnit) {
        this.pageSizeUnit = pageSizeUnit;
    }

    public double getPageSize() {
        return pageSize;
    }

    public void setPageSize(double pageSize) {
        this.pageSize = pageSize;
    }

    public int getRedundancy() {
        return redundancy;
    }

    public void setRedundancy(int redundancy) {
        this.redundancy = redundancy;
    }

    public double calculatePerSecond() {
        double perSecond = 0;
        switch (getPerTimePeriod()) {
            case 1:
                perSecond = .000008;
                break;
            case 2:
                perSecond = .000000133333;
                break;
            case 3:
                perSecond = .0000000022222;
                break;
            case 4:
                perSecond = .00000000009259259;
                break;
            case 5:    
                perSecond = .00000000001322751;
                break;
            case 6:
                perSecond = .0000000000030420564301;
                break;
            case 7:
                perSecond = .0000000000002535047025;
                break;
        }
        switch (getPageSizeUnit()) {
            case 1:
                perSecond = perSecond * getPageViews() * getRedundancy();
                break;
            case 2:
                perSecond = perSecond * getPageViews() * 1_000 * getRedundancy();
                break;
            case 3:
                perSecond = perSecond * 1_000_000 * getPageViews() * getRedundancy();
                break;
            case 4:
                perSecond = perSecond * getPageViews() * Math.pow(10, 9) * getRedundancy();
                break;
            case 5:
                perSecond = perSecond * getPageViews() * Math.pow(10, 12) * getRedundancy();
                break;
        }
        return perSecond;
    }

    public double calculatePerMonth() {
        double perMonth = 0;
        switch (getPerTimePeriod()) {
            case 1:
                perMonth = .0026298;
                break;
            case 2:
                perMonth = .00004383;
                break;
            case 3:
                perMonth = .0000007305;
                break;
            case 4:
                perMonth = .0000000304375;
                break;
            case 5:
                perMonth = .0000000043482142857143;
                break;
            case 6:
                perMonth = .000000001;
                break;
            case 7:
                perMonth = .0000000000833;
                break;
        }
        switch (getPageSizeUnit()) {
            case 1:
                perMonth = perMonth * getPageViews() * getRedundancy();
                break;
            case 2:
                perMonth = perMonth * getPageViews() * 1_000 * getRedundancy();
                break;
            case 3:
                perMonth = perMonth * 1_000_000 * getPageViews() * getRedundancy();
                break;
            case 4:
                perMonth = perMonth * getPageViews() * Math.pow(10, 9) * getRedundancy();
                break;
            case 5:
                perMonth = perMonth * getPageViews() * Math.pow(10, 12) * getRedundancy();
                break;
        }
        return perMonth;
    }
}
