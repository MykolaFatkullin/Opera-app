package com.tickets.service.dto;

import com.tickets.model.Movie;
import com.tickets.model.dto.MovieRequestDto;
import com.tickets.model.dto.MovieResponseDto;

public interface MovieMapper extends GenericDto<MovieResponseDto, MovieRequestDto, Movie> {

}
