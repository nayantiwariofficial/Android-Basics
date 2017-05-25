/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static com.example.android.miwok.R.id.numbers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        final TextView numbers = (TextView) findViewById(R.id.numbers);
        numbers.setOnClickListener(this);
        final TextView phrase = (TextView) findViewById(R.id.phrases);
        phrase.setOnClickListener(this);

        final TextView family = (TextView) findViewById(R.id.family);
        family.setOnClickListener(this);

        final TextView color = (TextView) findViewById(R.id.colors);
        color.setOnClickListener(this);

//        final TextView numberTextView = (TextView) findViewById(numbers);
//        numberTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loadActivity(numberTextView);
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.numbers:
            case R.id.phrases:
            case R.id.family:
            case R.id.colors:
                loadActivity((TextView) view);
                break;
        }
    }

    private void loadActivity(TextView textView){
        Intent intent = new Intent(MainActivity.this, GeneralActivity.class);
        intent.putExtra("NUMBER_KEY", textView.getText().toString());
//        intent.putExtra("COLOR_KEY", ((ColorDrawable)textView.getBackground()).getColor());
        intent.putExtra("COLOR_DRAWABLE_KEY", new ColorWrapper(textView.getBackground()));
        startActivity(intent);
    }
}
