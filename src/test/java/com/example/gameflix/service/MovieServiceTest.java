package com.example.gameflix.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    void getAllMovies_ShouldReturnList() {
        var movies = movieService.getAllMovies();
        Assertions.assertFalse(movies.isEmpty(), "Movie list should not be empty");
    }

    @Test
    void movieExists_ShouldReturnTrue_WhenMovieIsPresent() {
        boolean exists = movieService.movieExists("Movie A");
        Assertions.assertTrue(exists, "Movie A should exist");
    }

    @Test
    void countMovies_ShouldReturnCorrectNumber() {
        int count = movieService.countMovies();
        Assertions.assertEquals(3, count, "There should be exactly 3 movies");
    }
}
