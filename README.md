# Movie Manager with JDBC (CRUD)

This is a simple Movie Manager project that demonstrates basic CRUD (Create, Read, Update, Delete) operations using JDBC (Java Database Connectivity) with a MySQL database. You can manage a list of movies with information such as title, director, genre, release year, country, and cast.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 17
- MySQL database
- Maven


## Database Configuration

  Create a MySQL database with the name db_practice. Define the movies table in your database using the following SQL script:

    CREATE TABLE movies (
    movie_id INT PRIMARY KEY AUTO_INCREMENT, 
    title VARCHAR(100) NOT NULL,
    director VARCHAR(50) NOT NULL,
    genre VARCHAR(70) NOT NULL,
    release_year DATE NOT NULL,
    country VARCHAR(50) NOT NULL,
    cast TEXT NOT NULL
    );

### Project Structure

The project includes the following components:

    src/main/java: Contains the Java source code.
    pom.xml: The Maven project configuration.
    Movie.java: A Java class representing the Movie entity.
    MovieDAO.java: The Data Access Object (DAO) class responsible for interacting with the database.
    App.java: The main class that demonstrates CRUD operations on movies.

### Usage

You can use the application to:

    Add new movies to the database
    Retrieve movies by ID
    Retrieve all movies
    Update movie information
    Delete movies by ID

The App.java class provides examples of how to use the MovieDAO for these operations.


## Clone the Repository

If you want to clone this project to your local machine, you can use Git. Open your terminal and run the following command:

  ```bash
  git clone https://github.com/sh4on/movie-manager.git