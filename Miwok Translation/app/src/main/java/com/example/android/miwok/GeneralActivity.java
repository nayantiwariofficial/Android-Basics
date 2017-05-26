package com.example.android.miwok;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.key;
import static android.R.attr.publicKey;
import static android.R.attr.type;
import static android.support.v7.widget.AppCompatDrawableManager.get;
import static com.example.android.miwok.GeneralActivity.Type.COLOR;
import static com.example.android.miwok.GeneralActivity.Type.PHRASES;
import static com.example.android.miwok.R.id.rootView;

/**
 * Created by nayantiwari on 5/23/17.
 */

public class GeneralActivity extends AppCompatActivity {

    public static enum Type {

        NUMBER("Numbers"),
        FAMILY("Colors"),
        COLOR("Phrases"),
        PHRASES("Family Members");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    private static final String TAG = "GeneralActivity";
    ArrayList<Word> numberArrayList = new ArrayList<Word>();
    ArrayList<Word> familyArrayList = new ArrayList<Word>();
    ArrayList<Word> colorArrayList = new ArrayList<Word>();
    ArrayList<Word> phrasesArrayList = new ArrayList<Word>();
    String key = "";
    WordAdapter itemsAdapterC, itemsAdapterP, itemsAdapterN, itemsAdapterF;
    private MediaPlayer mMediaPlayer;
    Word word;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
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
                            ColorWrapper colorWrapper = (ColorWrapper) drawableKey;
                            supportActionBar.setBackgroundDrawable(colorWrapper.getColorDrawable());

                        }
                    }
                }
            }
        }

        if (key.equals("Numbers")) {
            numberArrayList.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
            numberArrayList.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
            numberArrayList.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
            numberArrayList.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
            numberArrayList.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
            numberArrayList.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
            numberArrayList.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
            numberArrayList.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
            numberArrayList.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
            numberArrayList.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));
            itemsAdapterN = new WordAdapter(this, numberArrayList, R.color.category_numbers);
            Log.i(TAG, "category_number ID " + R.color.category_numbers);
        }
        if (key.equals("Family Members")) {
            familyArrayList.add(new Word("father", "әpә", R.drawable.family_father, R.raw.family_father));
            familyArrayList.add(new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
            familyArrayList.add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
            familyArrayList.add(new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
            familyArrayList.add(new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
            familyArrayList.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
            familyArrayList.add(new Word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
            familyArrayList.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
            familyArrayList.add(new Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
            familyArrayList.add(new Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));
            itemsAdapterF = new WordAdapter(this, familyArrayList, R.color.category_family);
        }

        if (key.equals("Colors")) {
            colorArrayList.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
            colorArrayList.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
            colorArrayList.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
            colorArrayList.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
            colorArrayList.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
            colorArrayList.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
            colorArrayList.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
            colorArrayList.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
            itemsAdapterC = new WordAdapter(this, colorArrayList, R.color.category_colors);
        }
        if (key.equals("Phrases")) {
            phrasesArrayList.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
            phrasesArrayList.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
            phrasesArrayList.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
            phrasesArrayList.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
            phrasesArrayList.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
            phrasesArrayList.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
            phrasesArrayList.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
            phrasesArrayList.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
            phrasesArrayList.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
            phrasesArrayList.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));
            itemsAdapterP = new WordAdapter(this, phrasesArrayList, R.color.category_phrases);
        }
        ListView rootView = (ListView) findViewById(R.id.rootView);
        assert rootView != null;
        if (key.equals("Numbers"))
            rootView.setAdapter(itemsAdapterN);
        if (key.equals("Family Members"))
            rootView.setAdapter(itemsAdapterF);
        if (key.equals("Colors"))
            rootView.setAdapter(itemsAdapterC);
        if (key.equals("Phrases"))
            rootView.setAdapter(itemsAdapterP);


        rootView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i(TAG, "onItemClick: key: " + key);
//                Type type = Type.valueOf(key);
                /*switch (type) {
                    case NUMBER:
                        word = numberArrayList.get(i);
                        break;
                    case FAMILY:
                        word = colorArrayList.get(i);
                        break;
                    case COLOR:
                        word = phrasesArrayList.get(i);
                        break;
                    case PHRASES:
                        word = familyArrayList.get(i);
                        break;
                }*/
                switch (key) {
                    case "Numbers":
                        word = numberArrayList.get(i);
                        break;
                    case "Colors":
                        word = colorArrayList.get(i);
                        break;
                    case "Phrases":
                        word = phrasesArrayList.get(i);
                        break;
                    case "Family Members":
                        word = familyArrayList.get(i);
                        break;
                }
//                Word word = (Word) adapterView.getSelectedItem();

                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(GeneralActivity.this, word.getMediaResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

}
