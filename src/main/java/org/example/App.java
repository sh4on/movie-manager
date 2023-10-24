package org.example;

import org.example.dao.MovieDAO;
import org.example.model.Movie;

import java.util.Calendar;
import java.sql.Date;

public class App {
    public static void main(String[] args) {

        MovieDAO movieDAO = new MovieDAO();

        // Creating and initializing movie objects.
        // The release date of The Shawshank Redemption movie is intentionally misspelled here.
        Movie movie1 = new Movie("The Shawshank Redemption", "Frank Darabont", "Drama", Date.valueOf("1894-9-23"), "USA", "Tim Robbins, Morgan Freeman");
        Movie movie2 = new Movie("The Godfather", "Francis Ford Coppola", "Crime", Date.valueOf("1972-2-24"), "USA", "Marlon Brando, Al Pacino");
        Movie movie3 = new Movie("The Dark Knight", "Christopher Nolan", "Action", Date.valueOf("2008-7-18"), "USA", "Christian Bale, Heath Ledger");

        // Saving movies to database.
        String messageS1 = movieDAO.addMovie(movie1);
        System.out.println(messageS1);

        String messageS2 = movieDAO.addMovie(movie2);
        System.out.println(messageS2);

        String messageS3 = movieDAO.addMovie(movie3);
        System.out.println(messageS3);

        // Updating movies in database.
        Movie updatedMovieObject = new Movie(1,"The Shawshank Redemption", "Frank Darabont", "Drama", Date.valueOf("1994-9-23"), "USA", "Tim Robbins, Morgan Freeman");
        String messageU = movieDAO.updateMovie(updatedMovieObject);
        System.out.println(messageU);

        // Retrieving a single movie from database.
        // Returns null if movie not found.
        Movie movie = movieDAO.getMovieById(1);

        if (movie != null) {
            System.out.println("Title: " + movie.getTitle());
        }

        // // Retrieving a all movies from database.
        for (Movie m : movieDAO.getAllMovies()) {
            System.out.println("Title: " + m.getTitle());
        }

        // Deleting a movie from database.
        String messageD = movieDAO.deleteMovieById(1);
        System.out.println(messageD);
    }
}


