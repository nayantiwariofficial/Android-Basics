package com.example.android.quakereport;

/**
 * Created by nayantiwari on 5/29/17.
 */

public class Quake {
    private String mLocation;
    private double mMag;
    private String mDayDate;

    public Quake(double mag, String location, String dayDate) {
        mLocation = location;
        mMag = mag;
        mDayDate = dayDate;
    }

    public String getLocation() {
        return mLocation;
    }

    public double getMag() {
        return mMag;
    }

    public String getDayDate() {
        return mDayDate;
    }
}
