package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import static android.view.View.*;

public class NumbersActivity extends AppCompatActivity{
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_numbers);
    }

//    @Override
//    public void onClick(View view) {
//        Toast.makeText(view.getContext(), "This is the implementation of onClick()", Toast.LENGTH_SHORT).show();
//    }
}