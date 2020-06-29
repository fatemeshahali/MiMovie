package com.shahali.mimovie;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private TextView tvMovieName;
    private TextView tvReleaseDate;
    private TextView tvMovieSummary;
    private ImageView ivMoviePoster;
    private ImageView ivMovieImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        iniViews();

    }

    void iniViews() {
        //get data
        String MovieName = getIntent().getExtras().getString("MovieName");
        String MovieImage = getIntent().getExtras().getString("MovieImage");
        String MoviePoster = getIntent().getExtras().getString("MoviePoster");
        String ReleaseDate = getIntent().getExtras().getString("ReleaseDate");
        String MovieSummary=getIntent().getExtras().getString("MovieSummary");

        //set poster movie chosen
        ivMoviePoster = findViewById(R.id.MoviePoster);
        Glide.with(this).load(MoviePoster).into(ivMoviePoster);

        //set text name movie chosen
        tvMovieName = findViewById(R.id.MovieName);
        tvMovieName.setText(MovieName);
        //set action bar with name movie chosen
        getSupportActionBar().setTitle(MovieName);

        //set text release date movie chosen
        tvReleaseDate = findViewById(R.id.ReleaseDate);
        tvReleaseDate.setText(ReleaseDate);

        //set text Summary movie chosen
        tvMovieSummary = findViewById(R.id.MovieSummary);
        tvMovieSummary.setText(MovieSummary);

        //set image movie chosen
        ivMovieImage = findViewById(R.id.MovieImage);
        Glide.with(this).load(MovieImage).into(ivMovieImage);

        //setup animation
        ivMoviePoster.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));

    }
}

