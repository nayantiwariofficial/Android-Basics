package com.example.nayantiwari.musicapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {
    AlbumAdapter albumInfoAdapter, albumAdapter;

    private static final String TAG = "AlbumActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        String albumName = null;
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                albumName = extras.getString(Commons.ALBUM_NAME_KEY);
                setTitle(albumName);
                Log.i(TAG, "onCreate: AlbumKey: " + albumName);
            }
        }

        ArrayList<Album> songArrayList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            songArrayList.add( new Album(albumName, "Song "+i, "3:48"));
        }

        ArrayList<Album> albumInfoList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            albumInfoList.add( new Album(albumName, "Song "+i, R.drawable.logo1));
        }
//
        albumInfoAdapter = new AlbumAdapter(this, albumInfoList);
        ListView rootView = (ListView) findViewById(R.id.song_list);
        rootView.setAdapter(albumInfoAdapter);

        albumAdapter = new AlbumAdapter(this, songArrayList);
        rootView.setAdapter(albumAdapter);

    }
}