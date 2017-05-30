package com.example.android.quakereport;

/**
 * Created by nayantiwari on 5/29/17.
 */

public class Quake {
    private String mLocation;
    private double mMag;
    private long mDayDate;
    private String mUrl;

    public Quake(double mag, String location, long dayDate, String url) {
        mLocation = location;
        mMag = mag;
        mDayDate = dayDate;
        mUrl = url;
    }

    public String getLocation() {
        return mLocation;
    }

    public double getMag() {
        return mMag;
    }

    public long getDayDate() {
        return mDayDate;
    }

    public String getUrl() { return mUrl;}
}
