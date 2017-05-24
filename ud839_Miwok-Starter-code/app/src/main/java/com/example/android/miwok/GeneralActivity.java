package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by nayantiwari on 5/23/17.
 */

public class GeneralActivity extends AppCompatActivity {

    private static final String TAG = "GeneralActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        String number_key = null;
//        if (savedInstanceState != null) {
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                number_key = extras.getString("NUMBER_KEY");
                setTitle(number_key);
                Log.i(TAG, "onCreate: NK: " + number_key);
//                int color_key = extras.getInt("COLOR_KEY");
//                ColorDrawable colorDrawable = new ColorDrawable(color_key);
                ActionBar supportActionBar = getSupportActionBar();

                if (supportActionBar != null) {
                    Object drawableKey = extras.get("COLOR_DRAWABLE_KEY");
                    if (drawableKey != null) {
                        if (drawableKey instanceof ColorWrapper) {
//                            supportActionBar.setBackgroundDrawable((Drawable) drawableKey);
                            ColorWrapper colorWrapper = (ColorWrapper) drawableKey;
                            supportActionBar.setBackgroundDrawable(colorWrapper.getColorDrawable());
                        }
                    }
                }
            }
        }
    }
}
