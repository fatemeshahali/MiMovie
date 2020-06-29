package com.shahali.themovieapp;
//Create an interface class to define program rules

import android.widget.ImageView;

public interface MovieItemClickListener {
    //Need an ImageView to share information between two fragments
    void onMoveClick(Movies movies, ImageView movieImageView);
}
