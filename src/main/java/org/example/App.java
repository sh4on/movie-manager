package org.example;

import org.example.dao.MovieDAO;
import org.example.model.Movie;

import java.sql.Date;

public class App {
    public static void main(String[] args) {
        String message;
        MovieDAO movieDAO = new MovieDAO();

        // Creating and initializing movie objects.
        // The original release date of The Shawshank Redemption movie is 1994-9-23.
        // We will fix this later with an update.
        Movie shawshankRedemption = new Movie(
                "The Shawshank Redemption",
                "Frank Darabont",
                "Drama",
                Date.valueOf("1984-9-23"),
                "USA",
                "Tim Robbins, Morgan Freeman");

        Movie godfather = new Movie(
                "The Godfather",
                "Francis Ford Coppola",
                "Crime",
                Date.valueOf("1972-2-24"),
                "USA",
                "Marlon Brando, Al Pacino");

        // Saving movies to database
        message = movieDAO.addMovie(shawshankRedemption);
        System.out.println(message);

        message = movieDAO.addMovie(godfather);
        System.out.println(message);


        // Retrieving a single movie
        Movie movie = movieDAO.getMovieById(1L);

        if (movie != null) {
            System.out.println("Title: " + movie.getTitle());
        } else {
            System.out.println("No movie found in database");
        }

        // Retrieving all movies
        for (Movie m : movieDAO.getAllMovies()) {
            System.out.println("Title: " + m.getTitle());
        }

        // Update movie
        Movie updatedShawshankRedemption = new Movie(
                1L,
                "The Shawshank Redemption",
                "Frank Darabont",
                "Drama",
                Date.valueOf("1994-9-23"),
                "USA",
                "Tim Robbins, Morgan Freeman");
        message = movieDAO.updateMovie(updatedShawshankRedemption);
        System.out.println(message);


        // Delete movie
        message = movieDAO.deleteMovieById(2L);
        System.out.println(message);
    }
}


