package com.example.nayantiwari.musicapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import static com.example.nayantiwari.musicapp.Commons.bitmap;

public class AlbumInfoActivity extends AppCompatActivity {
    private static final String TAG = "AlbumActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_info);
        String albumName = null;
        Intent intent = getIntent();
        if (intent != null) {
        Bundle extras = intent.getExtras();
            if (extras != null) {
                albumName = extras.getString(Commons.ALBUM_NAME_KEY);
                setTitle(albumName);
                Log.i(TAG, "onCreate: AlbumKey: " + albumName);
//
//        Bitmap bitmap = (Bitmap) extras.get("BITMAP_KEY");
//        ImageView mImg = (ImageView) findViewById(R.id.album1_1);
//                BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
//        mImg.setImageBitmap(bitmap);


            }
        }
    }
}
