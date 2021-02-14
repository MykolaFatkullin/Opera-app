package com.tickets.service.model.impl;

import com.tickets.dao.MovieSessionDao;
import com.tickets.model.MovieSession;
import com.tickets.service.model.MovieSessionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    private final MovieSessionDao movieSessionDao;

    public MovieSessionServiceImpl(MovieSessionDao movieSessionDao) {
        this.movieSessionDao = movieSessionDao;
    }

    @Override
    public MovieSession add(MovieSession movieSession) {
        return movieSessionDao.add(movieSession);
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public void update(MovieSession movieSession) {
        movieSessionDao.update(movieSession);
    }

    @Override
    public void delete(MovieSession movieSession) {
        movieSessionDao.delete(movieSession);
    }
}
