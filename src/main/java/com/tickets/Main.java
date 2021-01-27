package com.tickets;

import com.tickets.lib.Injector;
import com.tickets.model.Movie;
import com.tickets.service.MovieService;

public class Main {
    private static final Injector injector = Injector.getInstance("com.tickets");

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        movieService.add(movie);

        movieService.getAll().forEach(System.out::println);
    }
}
