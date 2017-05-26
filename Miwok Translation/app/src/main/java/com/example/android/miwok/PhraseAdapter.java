//package com.example.android.miwok;
//
//import android.app.Activity;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
///**
// * Created by nayantiwari on 5/25/17.
// */
//
//public class PhraseAdapter extends ArrayAdapter<Word> {
//
//    public PhraseAdapter(Activity context, ArrayList<Word> words) {
//        super(context, 0, words);
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        View listItemView = convertView;
//        if (listItemView == null) {
//            listItemView = LayoutInflater.from(getContext()).inflate(
//                    R.layout.list_item_no_image, parent, false);
//        }
//
//        Word currentWord = getItem(position);
//
//        TextView nameTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
//        nameTextView.setText(currentWord.getDefaultTranslation());
//
//        TextView numberTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
//        numberTextView.setText(currentWord.getMiwokTranslation());
//
//        return listItemView;
//    }
//}