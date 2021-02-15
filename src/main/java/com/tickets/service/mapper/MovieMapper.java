package com.tickets.service.mapper;

import com.tickets.model.Movie;
import com.tickets.model.dto.MovieRequestDto;
import com.tickets.model.dto.MovieResponseDto;

public interface MovieMapper extends GenericMapToDto<MovieResponseDto, Movie>,
        GenericDtoToMap<MovieRequestDto, Movie> {
}
