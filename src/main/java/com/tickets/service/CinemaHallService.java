package com.tickets.service;

import com.tickets.lib.Service;
import com.tickets.model.CinemaHall;
import java.util.List;

@Service
public interface CinemaHallService {
    CinemaHall add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();
}
