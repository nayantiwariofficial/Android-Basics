package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by nayantiwari on 5/25/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Activity context, ArrayList<Word> words){
        super(context, 0, words);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        Log.i(TAG, "getView: "+ "WE    ARE      SOMEWHERE");
        nameTextView.setText(currentWord.getDefaultTranslation());

        TextView numberTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        Log.i(TAG, "getView: "+ "WE    ARE      SOMEWHERE");
        numberTextView.setText(currentWord.getMiwokTranslation());

        return listItemView;
    }
}
