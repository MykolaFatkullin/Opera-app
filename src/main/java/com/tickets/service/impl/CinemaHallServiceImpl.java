package com.tickets.service.impl;

import com.tickets.dao.CinemaHallDao;
import com.tickets.lib.Inject;
import com.tickets.lib.Service;
import com.tickets.model.CinemaHall;
import com.tickets.service.CinemaHallService;
import java.util.List;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    @Inject
    private CinemaHallDao cinemaHallDao;

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return cinemaHallDao.add(cinemaHall);
    }

    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }
}
