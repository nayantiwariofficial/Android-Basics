package com.example.android.miwok;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.attr.key;
import static android.support.v7.widget.StaggeredGridLayoutManager.TAG;
import static com.example.android.miwok.R.id.rootView;


public class GeneralFragment extends Fragment {

    public static final String NUMBER_KEY = "NUMBER_KEY";

    private static final String TAG = "GeneralActivity";
    private ArrayList<Word> numberArrayList = new ArrayList<Word>();
    private ArrayList<Word> familyArrayList = new ArrayList<Word>();
    private ArrayList<Word> colorArrayList = new ArrayList<Word>();
    private ArrayList<Word> phrasesArrayList = new ArrayList<Word>();
    private String key = "";
    private WordAdapter itemsAdapterC, itemsAdapterP, itemsAdapterN, itemsAdapterF;
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private Word word;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    public static GeneralFragment newInstance(String position) {
        Bundle args = new Bundle();
        args.putString(NUMBER_KEY, position);
        GeneralFragment fragment = new GeneralFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View mainView = inflater.inflate(R.layout.list_item, container, false);
        View mainView = inflater.inflate(R.layout.activity_numbers, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        key = getArguments().getString(NUMBER_KEY, "Numbers");
        /*Intent intent = getActivity().getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                key = extras.getString("NUMBER_KEY");
//                getActivity().setTitle(key);
                Log.i(TAG, "onCreate: NK: " + key);
//                int color_key = extras.getInt("COLOR_KEY");
//                ColorDrawable colorDrawable = new ColorDrawable(color_key);
            }
        }*/

        switch (key) {

            case "Numbers":
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
                itemsAdapterN = new WordAdapter(getActivity(), numberArrayList, R.color.category_numbers);
                break;

            case "Family Members":
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
                itemsAdapterF = new WordAdapter(getActivity(), familyArrayList, R.color.category_family);
                break;

            case "Colors":
                colorArrayList.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
                colorArrayList.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
                colorArrayList.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
                colorArrayList.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
                colorArrayList.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
                colorArrayList.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
                colorArrayList.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
                colorArrayList.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
                itemsAdapterC = new WordAdapter(getActivity(), colorArrayList, R.color.category_colors);
                break;

            case "Phrases":
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
                itemsAdapterP = new WordAdapter(getActivity(), phrasesArrayList, R.color.category_phrases);
                break;

            default:
                Log.i(TAG, "onCreateView: " + key);
                break;
        }
        ListView rootView = (ListView) mainView.findViewById(R.id.rootView);
        assert rootView != null;
        switch (key) {
            case "Numbers":
                rootView.setAdapter(itemsAdapterN);
                break;
            case "Family Members":
                rootView.setAdapter(itemsAdapterF);
                break;
            case "Colors":
                rootView.setAdapter(itemsAdapterC);
                break;
            case "Phrases":
                rootView.setAdapter(itemsAdapterP);
                break;
            default:
                Log.i(TAG, "Key Value Didn't match");
                break;
        }


        rootView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.i(TAG, "onItemClick: key: " + key);

                switch (key) {
                    case "Numbers":
                        word = numberArrayList.get(position);
                        break;
                    case "Colors":
                        word = colorArrayList.get(position);
                        break;
                    case "Phrases":
                        word = phrasesArrayList.get(position);
                        break;
                    case "Family Members":
                        word = familyArrayList.get(position);
                        break;
                }

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getMediaResourceId());
                    mMediaPlayer.start();

                }
            }
        });
        return mainView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
