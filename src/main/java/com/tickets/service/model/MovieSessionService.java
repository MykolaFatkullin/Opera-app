package com.tickets.service.model;

import com.tickets.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionService {
    MovieSession add(MovieSession movieSession);

    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    void update(MovieSession movieSession);

    void delete(MovieSession movieSession);
}
