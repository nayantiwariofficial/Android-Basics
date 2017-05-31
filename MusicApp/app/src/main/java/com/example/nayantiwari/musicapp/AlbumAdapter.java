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

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by nayantiwari on 5/26/17.
 */

public class AlbumAdapter extends ArrayAdapter<Album> {

    private int mSongNumbers;
    private boolean flag;

    public AlbumAdapter(Activity context, ArrayList<Album> albums, boolean flag) {
        super(context, 0, albums);
        mSongNumbers = albums.size();
        this.flag = flag;
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

        TextView albumTextView = (TextView) albumView.findViewById(R.id.album_name);
//        albumTextView.setText(currentAlbum.getAlbumName());

        TextView songTextView = (TextView) albumView.findViewById(R.id.song_name);
        songTextView.setText(currentAlbum.getSongName());

        TextView durationTextView = (TextView) albumView.findViewById(R.id.duration);
        durationTextView.setText(currentAlbum.getSongDuration());

        TextView songNumberTextView = (TextView) albumView.findViewById(R.id.song_numbers);

        TextView artistNameTextView = (TextView) albumView.findViewById(R.id.artist_name);

//        if(currentAlbum.getSongNumber() == 0)
//            songNumberTextView.setVisibility(View.GONE);
//        else
//            songNumberTextView.setText("Number of Songs: " + mSongNumbers);
//            songNumberTextView.setVisibility(View.VISIBLE);

        ImageView reqImageView = (ImageView) albumView.findViewById(R.id.album_art);

        if (currentAlbum.hasImage()) {
            boolean showImage = false;
            if (flag) {
                showImage = true;
            } else if (position == 0) {
                showImage = true;
            }
            if (showImage) {
                reqImageView.setImageResource(currentAlbum.getImageResourceId());
                albumTextView.setText(currentAlbum.getAlbumName());
                songNumberTextView.setText(currentAlbum.getSongNumber());
                songNumberTextView.setVisibility(View.VISIBLE);
                artistNameTextView.setText(R.string.artistName);
                artistNameTextView.setVisibility(View.VISIBLE);
                reqImageView.setVisibility(View.VISIBLE);
                albumTextView.setVisibility(View.VISIBLE);
            } else {
                reqImageView.setVisibility(View.GONE);
                songNumberTextView.setVisibility(View.GONE);
                albumTextView.setVisibility(View.GONE);
                artistNameTextView.setVisibility(View.GONE);
            }
        } else {
            reqImageView.setVisibility(View.GONE);
        }
        return albumView;
    }
}