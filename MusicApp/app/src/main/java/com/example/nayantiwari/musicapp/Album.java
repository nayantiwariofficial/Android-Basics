package com.example.nayantiwari.musicapp;

/**
 * Created by nayantiwari on 5/26/17.
 */

public class Album {
    private String mAlbumName;
    private String mSongName;
    private String mSongDuration;
    private int mSongNumber;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;


    public Album(String albumName, String songName, int imageResourceId) {
        mSongNumber = 0;
        mAlbumName =  albumName;
        mSongName = songName;
        mImageResourceId = imageResourceId;
    }
    public Album(String albumName, String songName, String songDuration)
    {
        mAlbumName = albumName;
        mSongName = songName;
        mSongDuration = songDuration;
    }

//    public Album(String defaultTranslation, String miwokTranslation){
//        mDefaultTranslation = defaultTranslation;
//        mMiwokTranslation = miwokTranslation;
//    }

    public String getAlbumName() {
        return mAlbumName;
    }

    public String getSongName() {
        return mSongName;
    }

    public String getSongDuration() {
        return mSongDuration;
    }

    public int getSongNumber() { return mSongNumber; }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
