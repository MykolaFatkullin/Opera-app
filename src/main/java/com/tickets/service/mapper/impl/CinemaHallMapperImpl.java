package com.tickets.service.mapper.impl;

import com.tickets.model.CinemaHall;
import com.tickets.model.dto.CinemaHallRequestDto;
import com.tickets.model.dto.CinemaHallResponseDto;
import com.tickets.service.mapper.CinemaHallMapper;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapperImpl implements CinemaHallMapper {

    @Override
    public CinemaHallResponseDto mapToDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto cinemaHallResponseDto = new CinemaHallResponseDto();
        cinemaHallResponseDto.setId(cinemaHall.getId());
        cinemaHallResponseDto.setCapacity(cinemaHall.getCapacity());
        cinemaHallResponseDto.setDescription(cinemaHall.getDescription());
        return cinemaHallResponseDto;
    }

    @Override
    public CinemaHall mapToEntity(CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallRequestDto.getCapacity());
        cinemaHall.setDescription(cinemaHallRequestDto.getDescription());
        return cinemaHall;
    }
}
