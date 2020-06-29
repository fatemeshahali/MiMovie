package com.shahali.themovieapp;
//Create model for ListAdapter
//Using the concept of encapsulation in object orientation, we define the required fields that we want to receive from the api
public class Movies {
    private String MovieName;
    private String ReleaseDate;
    private String MovieSummary;
    private String MoviePoster;
    private String MovieImage;

    public Movies(String movieName, String releaseDate, String movieSummary, String moviePoster, String movieImage) {
        MovieName = movieName;
        ReleaseDate = releaseDate;
        MovieSummary = movieSummary;
        MoviePoster = moviePoster;
        MovieImage = movieImage;
    }




    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public String getMovieSummary() {
        return MovieSummary;
    }

    public void setMovieSummary(String movieSummary) {
        MovieSummary = movieSummary;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public String getMoviePoster() {
        return MoviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        MoviePoster = moviePoster;
    }

    public String getMovieImage() {
        return MovieImage;
    }

    public void setMovieImage(String movieImage) {
        MovieImage = movieImage;
    }
}
