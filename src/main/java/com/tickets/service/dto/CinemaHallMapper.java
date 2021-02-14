package com.tickets.service.dto;

import com.tickets.model.CinemaHall;
import com.tickets.model.dto.CinemaHallRequestDto;
import com.tickets.model.dto.CinemaHallResponseDto;

public interface CinemaHallMapper extends GenericDto
        <CinemaHallResponseDto, CinemaHallRequestDto, CinemaHall> {

}
