package com.tickets.controller;

import com.tickets.model.Movie;
import com.tickets.model.dto.MovieRequestDto;
import com.tickets.model.dto.MovieResponseDto;
import com.tickets.service.mapper.MovieMapper;
import com.tickets.service.model.MovieService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @PostMapping
    public void addMovie(@RequestBody @Valid MovieRequestDto movieRequestDto) {
        Movie movie = movieMapper.mapToEntity(movieRequestDto);
        movieService.add(movie);
    }

    @GetMapping
    public List<MovieResponseDto> getAllMovies() {
        return movieService.getAll()
                .stream()
                .map(movieMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
