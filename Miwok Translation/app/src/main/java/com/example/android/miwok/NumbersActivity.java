//package com.example.android.miwok;
//
//import android.content.Intent;
//import android.support.v7.app.ActionBar;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//import static com.example.android.miwok.R.id.rootView;
//
//public class NumbersActivity extends AppCompatActivity {
//    private static final String TAG = "MainActivity";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        String number_key;
//        setContentView(R.layout.activity_numbers);
//
//        Intent intent = getIntent();
//        Bundle extras = intent.getExtras();
//        number_key = extras.getString("NUMBER_KEY");
//        setTitle(number_key);
//
//        ActionBar supportActionBar = getSupportActionBar();
//        Object drawable_key = extras.get("COLOR_DRAWABLE_KEY");
//        ColorWrapper colorWrapper = (ColorWrapper) drawable_key;
//        assert supportActionBar != null;
//        supportActionBar.setBackgroundDrawable(colorWrapper.getColorDrawable());
//
//        ArrayList<Word> numbersArrayList = new ArrayList<Word>();
//        numbersArrayList.add(new Word("one","lutti"));
//        numbersArrayList.add(new Word("two","otiiko"));
//        numbersArrayList.add(new Word("three","tolookosu"));
//        numbersArrayList.add(new Word("four","oyyisa"));
//        numbersArrayList.add(new Word("five","massokka"));
//        numbersArrayList.add(new Word("six","temmokka"));
//        numbersArrayList.add(new Word("seven","kenekaku"));
//        numbersArrayList.add(new Word("eight","kawinta"));
//        numbersArrayList.add(new Word("nine","wo'e"));
//        numbersArrayList.add(new Word("ten","na'aacha"));
//
//        WordAdapter itemsAdapter = new WordAdapter(this, numbersArrayList);
//        ListView rootView = (ListView) findViewById(R.id.rootView);
////        for (int i = 0; i < numbersArrayList.size(); i++) {
////            TextView wordView = new TextView(this);
////            wordView.setText(numbersArrayList.get(i));
////            rootView.addView(wordView);
////        }
//        rootView.setAdapter(itemsAdapter);
//    }
//}