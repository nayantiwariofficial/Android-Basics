package com.example.android.miwok;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nayantiwari on 5/25/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mBackgroundColor;

    public WordAdapter(Activity context, ArrayList<Word> words, int color) {
        super(context, 0, words);
        mBackgroundColor = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        nameTextView.setText(currentWord.getDefaultTranslation());

        TextView numberTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        numberTextView.setText(currentWord.getMiwokTranslation());

        ImageView reqImageView = (ImageView) listItemView.findViewById(R.id.required_image);

//        linearLayout.setBackgroundColor(0xFFFF0033);

        LinearLayout linearLayout = (LinearLayout) listItemView.findViewById(R.id.linear_layout_main);
        int color = ContextCompat.getColor(getContext(), mBackgroundColor);
        linearLayout.setBackgroundColor(color);

        if (currentWord.hasImage()) {
            reqImageView.setImageResource(currentWord.getImageResourceId());
            reqImageView.setVisibility(View.VISIBLE);
        } else {
            reqImageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
