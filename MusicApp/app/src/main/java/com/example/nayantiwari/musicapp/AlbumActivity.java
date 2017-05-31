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

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class AlbumActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    AlbumAdapter albumInfoAdapter, albumAdapter;
    ArrayList<Album> songArrayList, albumInfoList;

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
            }
        }
        String albumNameTemp = null;
        if (albumName != null) {
             albumNameTemp = albumName.substring(0, 7);
        }
        boolean flag = getIntent().getExtras().getBoolean("FLAG_KEY");
        if(flag) {
            songArrayList = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                    songArrayList.add(new Album(albumName, "Song " + i, "3:48"));
            }
        }
        else {
            albumInfoList = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                albumInfoList.add(new Album(albumNameTemp, "Song " + i, R.drawable.logo1, "3:48", "10"));
            }
        }
//
        ListView rootView = (ListView) findViewById(R.id.song_list);

        if(!flag)
        {
            albumInfoAdapter = new AlbumAdapter(this, albumInfoList, flag);
            rootView.setAdapter(albumInfoAdapter);
        }
        else {
            albumAdapter = new AlbumAdapter(this, songArrayList, flag);
            rootView.setAdapter(albumAdapter);
        }

    }
}