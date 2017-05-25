package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by nayantiwari on 5/23/17.
 */

public class GeneralActivity extends AppCompatActivity {

    private static final String TAG = "GeneralActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        String key = "";
//        if (savedInstanceState != null) {
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                key = extras.getString("NUMBER_KEY");
                setTitle(key);
                Log.i(TAG, "onCreate: NK: " + key);
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
//        ArrayList<Word> wordArrayList = new ArrayList<Word>();
//        if(key == "Numbers") {
        ArrayList<Word> numberArrayList = new ArrayList<Word>();
        numberArrayList.add(new Word("one", "lutti"));
        numberArrayList.add(new Word("two", "otiiko"));
        numberArrayList.add(new Word("three", "tolookosu"));
        numberArrayList.add(new Word("four", "oyyisa"));
        numberArrayList.add(new Word("five", "massokka"));
        numberArrayList.add(new Word("six", "temmokka"));
        numberArrayList.add(new Word("seven", "kenekaku"));
        numberArrayList.add(new Word("eight", "kawinta"));
        numberArrayList.add(new Word("nine", "wo'e"));
        numberArrayList.add(new Word("ten", "na'aacha"));
        WordAdapter itemsAdapterN = new WordAdapter(this, numberArrayList);

//        }
//        else if(key == "Family Members")
//        {
        ArrayList<Word> familyArrayList = new ArrayList<Word>();
        familyArrayList.add(new Word("father", "әpә"));
        familyArrayList.add(new Word("mother", "әṭa"));
        familyArrayList.add(new Word("son", "angsi"));
        familyArrayList.add(new Word("daughter", "tune"));
        familyArrayList.add(new Word("older brother", "taachi"));
        familyArrayList.add(new Word("younger brother", "chalitti"));
        familyArrayList.add(new Word("older sister", "teṭe"));
        familyArrayList.add(new Word("younger sister", "kolliti"));
        familyArrayList.add(new Word("grandmother", "ama"));
        familyArrayList.add(new Word("grandfather", "paapa"));
        WordAdapter itemsAdapterF = new WordAdapter(this, familyArrayList);
//        }

//        else if(key == "Colors")
//        {
        ArrayList<Word> colorArrayList = new ArrayList<Word>();
        colorArrayList.add(new Word("red", "weṭeṭṭi"));
        colorArrayList.add(new Word("green", "chokokki"));
        colorArrayList.add(new Word("brown", "ṭakaakki"));
        colorArrayList.add(new Word("gray", "ṭopoppi"));
        colorArrayList.add(new Word("black", "kululli"));
        colorArrayList.add(new Word("white", "kelelli"));
        colorArrayList.add(new Word("dusty yellow", "ṭopiisә"));
        colorArrayList.add(new Word("mustard yellow", "chiwiiṭә"));
        WordAdapter itemsAdapterC = new WordAdapter(this, colorArrayList);
//        }
//        else if(key == "Phrases")
//        {
        ArrayList<Word> phrasesArrayList = new ArrayList<Word>();
        phrasesArrayList.add(new Word("Where are you going?", "minto wuksus"));
        phrasesArrayList.add(new Word("What is your name?", "tinnә oyaase'nә"));
        phrasesArrayList.add(new Word("My name is...", "oyaaset..."));
        phrasesArrayList.add(new Word("How are you feeling?", "michәksәs?"));
        phrasesArrayList.add(new Word("I’m feeling good.", "kuchi achit"));
        phrasesArrayList.add(new Word("Are you coming?", "әәnәs'aa?"));
        phrasesArrayList.add(new Word("Yes, I’m coming.", "hәә’ әәnәm"));
        phrasesArrayList.add(new Word("I’m coming.", "әәnәm"));
        phrasesArrayList.add(new Word("Let’s go.", "yoowutis"));
        phrasesArrayList.add(new Word("Come here.", "әnni'nem"));
        WordAdapter itemsAdapterP = new WordAdapter(this, phrasesArrayList);

//        }
//        assert key != null;
//        if (key.equals("Numbers"))

        ListView rootView = (ListView) findViewById(R.id.rootView);
//        for (int i = 0; i < numbersArrayList.size(); i++) {
//            TextView wordView = new TextView(this);
//            wordView.setText(numbersArrayList.get(i));
//            rootView.addView(wordView);
//        }
        assert rootView != null;
        if(key.equals("Numbers"))
        rootView.setAdapter(itemsAdapterN);
        if(key.equals("Family Members"))
            rootView.setAdapter(itemsAdapterF);
        if(key.equals("Colors"))
            rootView.setAdapter(itemsAdapterC);
        if(key.equals("Phrases"))
            rootView.setAdapter(itemsAdapterP);
    }
}
