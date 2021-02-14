package com.tickets.service.dto.impl;

import com.tickets.model.CinemaHall;
import com.tickets.model.Movie;
import com.tickets.model.MovieSession;
import com.tickets.model.dto.MovieSessionRequestDto;
import com.tickets.model.dto.MovieSessionResponseDto;
import com.tickets.service.dto.MovieSessionMapper;
import com.tickets.service.model.CinemaHallService;
import com.tickets.service.model.MovieService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

@Service
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        movieSessionResponseDto.setShowTime(movieSession.getShowTime().format(formatter));
        return movieSessionResponseDto;
    }

    @Override
    public MovieSession dtoToMap(MovieSessionRequestDto movieSessionRequestDto) {
        Movie movie = movieService.getById(Long.valueOf(movieSessionRequestDto.getMovieId()));
        CinemaHall cinemaHall = cinemaHallService.getById(Long.valueOf(
                movieSessionRequestDto.getCinemaHallId()));
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setShowTime(LocalDateTime.parse(movieSessionRequestDto.getShowTime(),
                DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")));
        return movieSession;
    }
}
