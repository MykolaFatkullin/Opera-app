package com.tickets.dao;

import com.tickets.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionDao {
    MovieSession add(MovieSession movieSession);

    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    void update(MovieSession movieSession);

    void delete(Long id);
}
