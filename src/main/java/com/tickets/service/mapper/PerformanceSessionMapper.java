package com.tickets.service.mapper;

import com.tickets.model.PerformanceSession;
import com.tickets.model.dto.PerformanceSessionRequestDto;
import com.tickets.model.dto.PerformanceSessionResponseDto;

public interface PerformanceSessionMapper extends
        GenericMapToDto<PerformanceSessionResponseDto, PerformanceSession>,
        GenericMapToEntity<PerformanceSessionRequestDto, PerformanceSession> {
}
