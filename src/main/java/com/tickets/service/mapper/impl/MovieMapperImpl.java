package com.tickets.service.mapper.impl;

import com.tickets.model.Movie;
import com.tickets.model.dto.MovieRequestDto;
import com.tickets.model.dto.MovieResponseDto;
import com.tickets.service.mapper.MovieMapper;
import org.springframework.stereotype.Service;

@Service
public class MovieMapperImpl implements MovieMapper {
    @Override
    public MovieResponseDto mapToDto(Movie movie) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setId(movie.getId());
        movieResponseDto.setTitle(movie.getTitle());
        movieResponseDto.setDescription(movie.getDescription());
        return movieResponseDto;
    }

    @Override
    public Movie dtoToMap(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());
        return movie;
    }
}
