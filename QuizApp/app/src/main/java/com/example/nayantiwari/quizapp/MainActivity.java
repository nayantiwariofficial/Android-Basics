package com.example.nayantiwari.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.nayantiwari.quizapp.R.id.checkBox1;
import static com.example.nayantiwari.quizapp.R.id.checkBox2;
import static com.example.nayantiwari.quizapp.R.id.checkBox3;
import static com.example.nayantiwari.quizapp.R.id.checkBox4;
import static com.example.nayantiwari.quizapp.R.id.checkBox5;
import static com.example.nayantiwari.quizapp.R.id.checkBox6;
import static com.example.nayantiwari.quizapp.R.id.checkBox7;
import static com.example.nayantiwari.quizapp.R.id.checkBox8;
import static com.example.nayantiwari.quizapp.R.id.editText1;

public class MainActivity extends AppCompatActivity {

    boolean question1 = false;
    boolean question2 = false;
    boolean question3 = false;
    boolean question4 = false;
    boolean question5 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkAnswers(View view) {

        checkQuestion1();
        checkQuestion2();
        checkQuestion3();
        checkQuestion4();
        checkQuestion5();

        if(question1 && question2 && question3 && question4 && question5)
        {
            Toast.makeText(this, "All your answers are correct", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkQuestion1() {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox4);

        if (checkBox2.isChecked() && !checkBox1.isChecked() && !checkBox3.isChecked()) {
            if (checkBox4.isChecked()) {
                question1 = true;
                Toast.makeText(this, "Question 1 is " + question1, Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "Question 1 is " + question1, Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "Question 1 is " + question1, Toast.LENGTH_SHORT).show();

    }

    private void checkQuestion2() {
        CheckBox checkBox5 = (CheckBox) findViewById(R.id.checkBox5);
        CheckBox checkBox6 = (CheckBox) findViewById(R.id.checkBox6);
        CheckBox checkBox7 = (CheckBox) findViewById(R.id.checkBox7);
        CheckBox checkBox8 = (CheckBox) findViewById(R.id.checkBox8);

        if (checkBox5.isChecked() && !checkBox7.isChecked() && !checkBox8.isChecked()) {
            if (checkBox6.isChecked()) {
                question2 = true;
                Toast.makeText(this, "Question 2 is " + question2, Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "Question 2 is " + question2, Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "Question 2 is " + question2, Toast.LENGTH_SHORT).show();
    }

    private void checkQuestion3() {
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);

        if (radioButton1.isChecked()) {
            question3 = true;
            Toast.makeText(this, "Question 3 is " + question3, Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "Question 3 is " + question3, Toast.LENGTH_SHORT).show();
    }

    private void checkQuestion4() {
        EditText editText1 = (EditText) findViewById(R.id.editText1);
        if(editText1.getText().toString().equalsIgnoreCase("George Washington")){
            question4 = true;
            Toast.makeText(this, "Question 4 is " + question4, Toast.LENGTH_SHORT).show();
        }
    }

    private void checkQuestion5() {
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        if(editText2.getText().toString().equalsIgnoreCase("Arizona State University") || editText2.getText().toString().equalsIgnoreCase("ASU")){
            question5 = true;
            Toast.makeText(this, "Question 5 is " + question5, Toast.LENGTH_SHORT).show();
        }
    }
}
