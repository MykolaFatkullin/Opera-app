package com.tickets.controller;

import com.tickets.model.Performance;
import com.tickets.model.dto.PerformanceRequestDto;
import com.tickets.model.dto.PerformanceResponseDto;
import com.tickets.service.mapper.PerformanceMapper;
import com.tickets.service.model.PerformanceService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performances")
public class PerformanceController {
    private final PerformanceService performanceService;
    private final PerformanceMapper performanceMapper;

    public PerformanceController(PerformanceService performanceService,
                                 PerformanceMapper performanceMapper) {
        this.performanceService = performanceService;
        this.performanceMapper = performanceMapper;
    }

    @PostMapping
    public void addPerformance(@RequestBody @Valid PerformanceRequestDto performanceRequestDto) {
        Performance performance = performanceMapper.mapToEntity(performanceRequestDto);
        performanceService.add(performance);
    }

    @GetMapping
    public List<PerformanceResponseDto> getAllPerformances() {
        return performanceService.getAll()
                .stream()
                .map(performanceMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
