package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.pets.data.PetContract;
import com.example.android.pets.data.PetContract.PetEntry;

/**
 * Created by nayantiwari on 6/9/17.
 */

public class PetCursorAdapter extends CursorAdapter {

    public PetCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView tVName = (TextView) view.findViewById(R.id.name);
        TextView tVSummary = (TextView) view.findViewById(R.id.summary);

        String pName = cursor.getString(cursor.getColumnIndexOrThrow(PetEntry.COLUMN_PET_NAME));
        String pSummary = cursor.getString(cursor.getColumnIndexOrThrow(PetEntry.COLUMN_PET_BREED));;

        if((cursor.getString(cursor.getColumnIndexOrThrow(PetEntry.COLUMN_PET_BREED))).isEmpty())
        {
            pSummary = context.getString(R.string.unknown_breed);
        }

        tVName.setText(pName);
        tVSummary.setText(pSummary);

    }
}
