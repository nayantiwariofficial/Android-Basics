package com.example.nayantiwari.quizapp;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean question1 = false;
    private boolean question2 = false;
    private boolean question3 = false;
    private boolean question4 = false;
    private boolean question5 = false;

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;
    private CheckBox checkBox7;
    private CheckBox checkBox8;

    private AppCompatImageView logo;
    private RadioGroup radioGroup;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.radioButton1:
                        Log.i(TAG, "onCheckedChanged: Radio 1 Selected");

                        logo.setVisibility(View.GONE);
                        break;
                    case R.id.radioButton2:
                        Log.i(TAG, "onCheckedChanged: Radio 2 Selected");

                        logo.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
    }

    public void init(){
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox5 = (CheckBox) findViewById(R.id.checkBox5);
        checkBox6 = (CheckBox) findViewById(R.id.checkBox6);
        checkBox7 = (CheckBox) findViewById(R.id.checkBox7);
        checkBox8 = (CheckBox) findViewById(R.id.checkBox8);

        logo = (AppCompatImageView) findViewById(R.id.logo);
    }

    public void checkAnswers(View view) {

        int score = 0;
        String incorrectQuestion = "";
        checkQuestion1();
        checkQuestion2();
        checkQuestion3();
        checkQuestion4();
        checkQuestion5();

        if (question1)
            score++;
        else incorrectQuestion += "1";
        if (question2)
            score++;
        else incorrectQuestion += " 2";
        if (question3)
            score++;
        else incorrectQuestion += " 3";
        if (question4)
            score++;
        else incorrectQuestion += " 4";
        if (question5)
            score++;
        else incorrectQuestion += " 5";

        Toast.makeText(this, "Your score " + score + "/5", Toast.LENGTH_SHORT).show();

        if((!(question1 && question2 && question3 && question4 && question5)))
            Toast.makeText(this, "Incorrect Questions are: " + incorrectQuestion, Toast.LENGTH_SHORT).show();
    }

    private void checkQuestion1() {
        if (checkBox2.isChecked() && !checkBox1.isChecked() && !checkBox3.isChecked()) {
            if (checkBox4.isChecked()) {
                question1 = true;
            }
        }
    }

    private void checkQuestion2() {
        if (checkBox5.isChecked() && !checkBox7.isChecked() && !checkBox8.isChecked()) {
            if (checkBox6.isChecked()) {
                question2 = true;
            }
        }
    }

    private void checkQuestion3() {
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);

        if (radioButton1.isChecked() && !radioButton2.isChecked()) {
            question3 = true;
        }
    }

    private void checkQuestion4() {
        EditText editText1 = (EditText) findViewById(R.id.editText1);
        if (editText1.getText().toString().equalsIgnoreCase("George Washington")) {
            question4 = true;
        }
    }

    private void checkQuestion5() {
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        if (editText2.getText().toString().equalsIgnoreCase("Arizona State University") || editText2.getText().toString().equalsIgnoreCase("ASU")) {
            question5 = true;
        }
    }
}