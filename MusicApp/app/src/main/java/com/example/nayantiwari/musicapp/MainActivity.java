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

        final ImageView albumClick = (ImageView) findViewById(R.id.album1_2);
        albumClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String tv = null;
                Bitmap bitmap = null;
                LinearLayout ll = (LinearLayout) v.getParent();
                for (int i = 0; i < ll.getChildCount(); i++) {
                    View view1 = ll.getChildAt(i);

                    if (view1 instanceof ImageView) {
                        ImageView imageView = (ImageView) view1;
                        BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
                        bitmap = bitmapDrawable.getBitmap();
                        Log.i(TAG, "onAlbumLongClick: " + bitmap);
                    }
                    if (view1 instanceof TextView) {
                        TextView textView = (TextView) view1;
                        tv = textView.getText().toString();
                        Log.i(TAG, "onAlbumClick: " + tv);
                    }
                }
                Intent intent = new Intent(MainActivity.this, AlbumInfoActivity.class);
                intent.putExtra("ALBUM_NAME_KEY", tv);
                intent.putExtra("ALBUM_ART_KEY", bitmap);
                startActivity(intent);
                return false;
            }
        });

    }

    public void onAlbumClick(View view) {

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