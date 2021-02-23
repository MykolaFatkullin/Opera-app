package com.tickets.service.mapper.impl;

import com.tickets.model.Performance;
import com.tickets.model.PerformanceSession;
import com.tickets.model.Stage;
import com.tickets.model.dto.PerformanceSessionRequestDto;
import com.tickets.model.dto.PerformanceSessionResponseDto;
import com.tickets.service.mapper.PerformanceSessionMapper;
import com.tickets.service.model.PerformanceService;
import com.tickets.service.model.StageService;
import org.springframework.stereotype.Component;

@Component
public class PerformanceSessionMapperImpl implements PerformanceSessionMapper {
    private final PerformanceService performanceService;
    private final StageService stageService;

    public PerformanceSessionMapperImpl(PerformanceService performanceService,
                                        StageService stageService) {
        this.performanceService = performanceService;
        this.stageService = stageService;
    }

    @Override
    public PerformanceSessionResponseDto mapToDto(PerformanceSession performanceSession) {
        PerformanceSessionResponseDto performanceSessionResponseDto =
                new PerformanceSessionResponseDto();
        performanceSessionResponseDto.setPerformanceTitle(performanceSession.getMovie().getTitle());
        performanceSessionResponseDto.setPerformanceDescriprion(performanceSession.getMovie()
                .getDescription());
        performanceSessionResponseDto.setStageDescription(performanceSession.getCinemaHall()
                .getDescription());
        performanceSessionResponseDto.setShowTime(performanceSession.getShowTime());
        return performanceSessionResponseDto;
    }

    @Override
    public PerformanceSession mapToEntity(
            PerformanceSessionRequestDto performanceSessionRequestDto) {
        Performance performance = performanceService.getById(performanceSessionRequestDto
                .getPerformanceId());
        Stage stage = stageService.getById(performanceSessionRequestDto.getStageId());
        PerformanceSession performanceSession = new PerformanceSession();
        performanceSession.setMovie(performance);
        performanceSession.setCinemaHall(stage);
        performanceSession.setShowTime(performanceSessionRequestDto.getShowTime());
        return performanceSession;
    }
}
