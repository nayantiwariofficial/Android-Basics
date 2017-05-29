package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by nayantiwari on 5/29/17.
 */

public class QuakeAdapter extends ArrayAdapter<Quake> {

    public QuakeAdapter(Activity context, ArrayList<Quake> quakes){
        super(context, 0, quakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View quakeListView = convertView;
        if(quakeListView == null){
            quakeListView = LayoutInflater.from(getContext()).inflate(R.layout.quake_list, parent, false);
        }

        Quake currentQuake = getItem(position);

        TextView quakeMag = (TextView) quakeListView.findViewById(R.id.mag);
        quakeMag.setText(""+currentQuake.getMag());

        TextView quakeLocation = (TextView) quakeListView.findViewById(R.id.location);
        quakeLocation.setText(currentQuake.getLocation());

        TextView quakeTime = (TextView) quakeListView.findViewById(R.id.time);
        quakeTime.setText(currentQuake.getDayDate());

        return quakeListView;
    }
}
