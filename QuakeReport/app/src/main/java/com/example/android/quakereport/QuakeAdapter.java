package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 * Created by nayantiwari on 5/29/17.
 */

public class QuakeAdapter extends ArrayAdapter<Quake> {

    public QuakeAdapter(Activity context, ArrayList<Quake> quakes) {
        super(context, 0, quakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View quakeListView = convertView;
        if (quakeListView == null) {
            quakeListView = LayoutInflater.from(getContext()).inflate(R.layout.quake_list, parent, false);
        }

        String primaryLocation;
        String locationOffset;

        Quake currentQuake = getItem(position);

        TextView quakeMag = (TextView) quakeListView.findViewById(R.id.mag);
        String formattedMagnitude = formatMagnitude(currentQuake.getMag());
        quakeMag.setText(formattedMagnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) quakeMag.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentQuake.getMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        String originalLocation = currentQuake.getLocation();


        if (originalLocation.contains("of")) {
            String[] parts = originalLocation.split("of ");
            locationOffset = parts[0] + "of";
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        TextView locationOffsetTextView = (TextView) quakeListView.findViewById(R.id.offset);
        locationOffsetTextView.setText(locationOffset);

        TextView quakeLocation = (TextView) quakeListView.findViewById(R.id.location);
        quakeLocation.setText(primaryLocation);

        Date quakeTime = new Date(currentQuake.getDayDate());
        TextView dateView = (TextView) quakeListView.findViewById(R.id.date);
        String formattedDate = formatDate(quakeTime);

        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) quakeListView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(quakeTime);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);


        // Return the list item view that is now showing the appropriate data


        return quakeListView;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double quakeMag) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(quakeMag);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
