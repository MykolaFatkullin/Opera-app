package com.tickets.service.mapper;

import com.tickets.model.Performance;
import com.tickets.model.dto.PerformanceRequestDto;
import com.tickets.model.dto.PerformanceResponseDto;

public interface PerformanceMapper extends GenericMapToDto<PerformanceResponseDto, Performance>,
        GenericMapToEntity<PerformanceRequestDto, Performance> {
}
