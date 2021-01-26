package com.tickets.service.impl;

import com.tickets.dao.MovieDao;
import com.tickets.lib.Inject;
import com.tickets.lib.Service;
import com.tickets.model.Movie;
import com.tickets.service.MovieService;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    private MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
