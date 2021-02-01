package com.tickets.service;

import com.tickets.lib.Service;
import com.tickets.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionService {
    MovieSession add(MovieSession movieSession);

    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);
}
