package com.tickets.service.mapper;

import com.tickets.model.MovieSession;
import com.tickets.model.dto.MovieSessionRequestDto;
import com.tickets.model.dto.MovieSessionResponseDto;

public interface MovieSessionMapper extends
        GenericMapToDto<MovieSessionResponseDto, MovieSession>,
        GenericMapToEntity<MovieSessionRequestDto, MovieSession> {
}
