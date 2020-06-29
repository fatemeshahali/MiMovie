package com.shahali.mimovie;
import android.widget.ImageView;

public interface MovieItemClickListener {
    //Need an ImageView to share information between two fragments
    void onMoveClick(Movie movies, ImageView movieImageView);
}