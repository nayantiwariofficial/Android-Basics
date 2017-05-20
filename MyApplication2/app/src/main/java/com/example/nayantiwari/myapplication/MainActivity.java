package com.example.nayantiwari.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.R.id.message;
import static android.graphics.Color.BLACK;
import static android.graphics.Color.GRAY;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setText("Wow!");
        textView.setTextColor(Color.RED);
        textView.setTextSize(40);
        
        setContentView(textView);
    }
}
