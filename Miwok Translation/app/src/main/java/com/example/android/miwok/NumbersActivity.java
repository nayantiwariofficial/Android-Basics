//package com.example.android.miwok;
//
//import android.content.Intent;
//import android.support.v7.app.ActionBar;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//
//
//public class NumbersActivity extends AppCompatActivity {
//    private static final String TAG = "NumbersACTIVITY";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_numbers);
//
//        String key = "";
////        if (savedInstanceState != null) {
//        Intent intent = getIntent();
//        if (intent != null) {
//            Bundle extras = intent.getExtras();
//            if (extras != null) {
//                key = extras.getString("NUMBER_KEY");
//                setTitle(key);
//                Log.i(TAG, "onCreate: NK: " + key);
////                int color_key = extras.getInt("COLOR_KEY");
////                ColorDrawable colorDrawable = new ColorDrawable(color_key);
//                ActionBar supportActionBar = getSupportActionBar();
//
//                if (supportActionBar != null) {
//                    Object drawableKey = extras.get("COLOR_DRAWABLE_KEY");
//                    if (drawableKey != null) {
//                        if (drawableKey instanceof ColorWrapper) {
//                            ColorWrapper colorWrapper = (ColorWrapper) drawableKey;
//                            supportActionBar.setBackgroundDrawable(colorWrapper.getColorDrawable());
//
//                        }
//                    }
//                }
//            }
//        }
//
//        ArrayList<Word> numberArrayList = new ArrayList<Word>();
//        numberArrayList.add(new Word("one", "lutti", R.drawable.number_one));
//        numberArrayList.add(new Word("two", "otiiko", R.drawable.number_two));
//        numberArrayList.add(new Word("three", "tolookosu", R.drawable.number_three));
//        numberArrayList.add(new Word("four", "oyyisa", R.drawable.number_four));
//        numberArrayList.add(new Word("five", "massokka", R.drawable.number_five));
//        numberArrayList.add(new Word("six", "temmokka", R.drawable.number_six));
//        numberArrayList.add(new Word("seven", "kenekaku", R.drawable.number_seven));
//        numberArrayList.add(new Word("eight", "kawinta", R.drawable.number_eight));
//        numberArrayList.add(new Word("nine", "wo'e", R.drawable.number_nine));
//        numberArrayList.add(new Word("ten", "na'aacha", R.drawable.number_ten));
//
//        WordAdapter itemsAdapter = new WordAdapter(this, numberArrayList, R.color.category_numbers);
//        ListView rootView = (ListView) findViewById(R.id.rootView);
//        assert rootView != null;
//        rootView.setAdapter(itemsAdapter);
//
//        rootView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(NumbersActivity.this, "Clicked list item", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}