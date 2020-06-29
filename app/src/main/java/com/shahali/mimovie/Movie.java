package com.shahali.mimovie;

public class Movie {

    private String MovieName;
    private String ReleaseDate;
    private String MovieSummary;
    private String MoviePoster;
    private String MovieImage;

    public Movie(String movieName, String releaseDate, String movieSummary, String moviePoster, String movieImage) {
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
