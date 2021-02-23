package com.tickets.service.mapper.impl;

import com.tickets.model.Performance;
import com.tickets.model.dto.PerformanceRequestDto;
import com.tickets.model.dto.PerformanceResponseDto;
import com.tickets.service.mapper.PerformanceMapper;
import org.springframework.stereotype.Component;

@Component
public class PerformanceMapperImpl implements PerformanceMapper {
    @Override
    public PerformanceResponseDto mapToDto(Performance performance) {
        PerformanceResponseDto movieResponseDto = new PerformanceResponseDto();
        movieResponseDto.setId(performance.getId());
        movieResponseDto.setTitle(performance.getTitle());
        movieResponseDto.setDescription(performance.getDescription());
        return movieResponseDto;
    }

    @Override
    public Performance mapToEntity(PerformanceRequestDto performanceRequestDto) {
        Performance performance = new Performance();
        performance.setTitle(performanceRequestDto.getTitle());
        performance.setDescription(performanceRequestDto.getDescription());
        return performance;
    }
}
