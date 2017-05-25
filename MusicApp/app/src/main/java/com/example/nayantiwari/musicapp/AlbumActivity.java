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

        ArrayList<String> songArrayList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            songArrayList.add("Song "+i);
        }

        Log.i(TAG, "Array list size "+ songArrayList.size());

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songArrayList);
        ListView rootView = (ListView) findViewById(R.id.songList);
        rootView.setAdapter(itemsAdapter);
//        for (int i = 0; i < songArrayList.size(); i++) {
//            TextView songNameTextView = new TextView(this);
//            View view = new View(this);
//            songNameTextView.setText(songArrayList.get(i));
//            songNameTextView.setTextAppearance(R.style.songName);
//            linearLayoutSongList.addView(songNameTextView);
//            linearLayoutSongList.addView(view);
//        }


    }
}