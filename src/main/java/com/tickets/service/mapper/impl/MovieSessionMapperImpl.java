package com.tickets.service.mapper.impl;

import com.tickets.model.CinemaHall;
import com.tickets.model.Movie;
import com.tickets.model.MovieSession;
import com.tickets.model.dto.MovieSessionRequestDto;
import com.tickets.model.dto.MovieSessionResponseDto;
import com.tickets.service.mapper.MovieSessionMapper;
import com.tickets.service.model.CinemaHallService;
import com.tickets.service.model.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapperImpl implements MovieSessionMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionMapperImpl(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    @Override
    public MovieSessionResponseDto mapToDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setMovieTitle(movieSession.getMovie().getTitle());
        movieSessionResponseDto.setMovieDescription(movieSession.getMovie().getDescription());
        movieSessionResponseDto.setCinemaHallDescription(movieSession.getCinemaHall()
                .getDescription());
        movieSessionResponseDto.setShowTime(movieSession.getShowTime());
        return movieSessionResponseDto;
    }

    @Override
    public MovieSession mapToEntity(MovieSessionRequestDto movieSessionRequestDto) {
        Movie movie = movieService.getById(movieSessionRequestDto.getMovieId());
        CinemaHall cinemaHall = cinemaHallService.getById(movieSessionRequestDto.getCinemaHallId());
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setShowTime(movieSessionRequestDto.getShowTime());
        return movieSession;
    }
}
