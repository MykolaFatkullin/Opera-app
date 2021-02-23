package com.opera.controller;

import com.opera.model.Performance;
import com.opera.model.dto.PerformanceRequestDto;
import com.opera.model.dto.PerformanceResponseDto;
import com.opera.service.mapper.PerformanceMapper;
import com.opera.service.model.PerformanceService;
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
