package com.opera.service.mapper.impl;

import com.opera.model.Performance;
import com.opera.model.dto.PerformanceRequestDto;
import com.opera.model.dto.PerformanceResponseDto;
import com.opera.service.mapper.PerformanceMapper;
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
