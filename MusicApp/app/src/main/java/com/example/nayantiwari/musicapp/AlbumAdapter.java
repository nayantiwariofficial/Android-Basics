package com.example.nayantiwari.musicapp;

import android.app.Activity;
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
 * Created by nayantiwari on 5/26/17.
 */

public class AlbumAdapter extends ArrayAdapter<Album> {

    public AlbumAdapter(Activity context, ArrayList<Album> albums) {
        super(context, 0, albums);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View albumView = convertView;
        if (albumView == null) {
            albumView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_album_info, parent, false);
        }
        Album currentAlbum = getItem(position);

//        TextView albumTextView = (TextView) albumView.findViewById(R.id.album_name);
//        albumTextView.setText(currentAlbum.getAlbumName());

        TextView songTextView = (TextView) albumView.findViewById(R.id.song_name);
        songTextView.setText(currentAlbum.getSongName());

        TextView durationTextView = (TextView) albumView.findViewById(R.id.duration);
        durationTextView.setText(currentAlbum.getSongDuration());

        ImageView reqImageView = (ImageView) albumView.findViewById(R.id.album_art);

        if (currentAlbum.hasImage()) {
            reqImageView.setImageResource(currentAlbum.getImageResourceId());
            reqImageView.setVisibility(View.VISIBLE);
        } else {
            reqImageView.setVisibility(View.GONE);
        }
        return albumView;
    }
}