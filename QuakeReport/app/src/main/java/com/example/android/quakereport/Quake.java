package com.example.android.quakereport;

/**
 * Created by nayantiwari on 5/29/17.
 */

public class Quake {
    private String mLocation;
    private double mMag;
    private long mDayDate;

    public Quake(double mag, String location, long dayDate) {
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

    public long getDayDate() {
        return mDayDate;
    }
}
