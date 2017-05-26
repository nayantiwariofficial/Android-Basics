package com.example.nayantiwari.musicapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.album1_1);
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                loadActivity(v);
                return false;
            }
        });
    }

    public void onAlbumClick(View view) {
        loadActivity(view);
    }

    public void loadActivity(View view) {
        String tv = null;
        LinearLayout ll = (LinearLayout) view.getParent();
        for (int i = 0; i < ll.getChildCount(); i++) {
            View view1 = ll.getChildAt(i);
            if (view1 instanceof TextView) {
                TextView textView = (TextView) view1;
                tv = textView.getText().toString();
                Log.i(TAG, "onAlbumClick: " + tv);
            }
        }
        Intent intent = new Intent(MainActivity.this, AlbumActivity.class);
        intent.putExtra(Commons.ALBUM_NAME_KEY, tv);
        startActivity(intent);
    }
}