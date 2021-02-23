package com.opera.service.mapper;

import com.opera.model.PerformanceSession;
import com.opera.model.dto.PerformanceSessionRequestDto;
import com.opera.model.dto.PerformanceSessionResponseDto;

public interface PerformanceSessionMapper extends
        GenericMapToDto<PerformanceSessionResponseDto, PerformanceSession>,
        GenericMapToEntity<PerformanceSessionRequestDto, PerformanceSession> {
}
