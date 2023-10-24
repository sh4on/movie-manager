package org.example.dao;

import org.example.model.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MovieDAO {
    private final String DB_URL = "jdbc:mysql://localhost:3306/db_practice";
    private final String USER = "root";
    private final String PASSWORD = "root";

    // SQL query constants
    private static final String INSERT_MOVIE = "INSERT INTO movies (title, director, genre, release_year, country, cast) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_MOVIE_BY_ID = "SELECT * FROM movies WHERE movie_id = ?";
    private static final String SELECT_ALL_MOVIES = "SELECT * FROM movies";
    private static final String DELETE_MOVIE_BY_ID = "DELETE FROM movies WHERE movie_id = ?";
    private static final String UPDATE_MOVIE = "UPDATE movies SET title = ?, director = ?, genre = ?, release_year = ?, country = ?, cast = ? WHERE movie_id = ?";

    public MovieDAO() {
    }

    private Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return connection;
    }

    public String addMovie(Movie movie) {
        String message = null;

        try {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MOVIE)) {

                preparedStatement.setString(1, movie.getTitle());
                preparedStatement.setString(2, movie.getDirector());
                preparedStatement.setString(3, movie.getGenre());
                preparedStatement.setDate(4, (Date) movie.getReleaseYear());
                preparedStatement.setString(5, movie.getCountry());
                preparedStatement.setString(6, movie.getCast());

                if (preparedStatement.executeUpdate() > 0) {
                    message = String.format("Movie (%s) saved successfully.", movie.getTitle());
                } else {
                    message = String.format("There seems to be a problem. Movie (%s) not saved.", movie.getTitle());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            message = e.getMessage();
        }

        return message;
    }

    public Movie getMovieById(int id) {
        Movie movie = null;

        try {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MOVIE_BY_ID)) {

                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    movie = createMovieObject(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movie;
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();

        try {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MOVIES)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    movies.add(createMovieObject(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movies;
    }

    public String updateMovie(Movie movie) {
        String message = null;

        try {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MOVIE)) {

                preparedStatement.setString(1, movie.getTitle());
                preparedStatement.setString(2, movie.getDirector());
                preparedStatement.setString(3, movie.getGenre());
                preparedStatement.setDate(4, (Date) movie.getReleaseYear());
                preparedStatement.setString(5, movie.getCountry());
                preparedStatement.setString(6, movie.getCast());
                preparedStatement.setInt(7, movie.getMovieID());

                if (preparedStatement.executeUpdate() > 0) {
                    message = String.format("Movie with ID %d updated successfully.", movie.getMovieID());
                } else {
                    message = String.format("There seems to be a problem. Movie with ID %d not Updated.", movie.getMovieID());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            message = e.getMessage();
        }

        return message;
    }

    public String deleteMovieById(int id) {
        String message = null;

        try {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MOVIE_BY_ID)) {

                preparedStatement.setInt(1, id);

                if (preparedStatement.executeUpdate() >= 0) {
                    message = String.format("Movie with ID %d deleted successfully.", id);
                } else {
                    message = String.format("There seems to be a problem. Movie with ID %d not deleted.", id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            message = e.getMessage();
        }

        return message;
    }

    private Movie createMovieObject(ResultSet resultSet) throws SQLException {
        Movie movie = new Movie();

        int movieID = resultSet.getInt("movie_id");
        String title = resultSet.getString("title");
        String director = resultSet.getString("director");
        String genre = resultSet.getString("genre");
        Date releaseYear = resultSet.getDate("release_year");
        String country = resultSet.getString("country");
        String cast = resultSet.getString("cast");

        movie.setMovieID(movieID);
        movie.setTitle(title);
        movie.setDirector(director);
        movie.setGenre(genre);
        movie.setReleaseYear(releaseYear);
        movie.setCountry(country);
        movie.setCast(cast);

        return movie;
    }
}
