package org.example.model;

import java.util.Date;

public class Movie {
    private int movieID;
    private String title;
    private String director;
    private String genre;
    private Date releaseYear;
    private String country;
    private String cast;

    public Movie() {
    }

    // Constructor without id field
    public Movie(String title, String director, String genre, Date releaseYear, String country, String cast) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.country = country;
        this.cast = cast;
    }

    public Movie(int movieID, String title, String director, String genre, Date releaseYear, String country, String cast) {
        this.movieID = movieID;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.country = country;
        this.cast = cast;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }
}
