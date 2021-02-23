package com.tickets.controller;

import com.tickets.model.PerformanceSession;
import com.tickets.model.dto.PerformanceSessionRequestDto;
import com.tickets.model.dto.PerformanceSessionResponseDto;
import com.tickets.service.mapper.PerformanceSessionMapper;
import com.tickets.service.model.PerformanceSessionService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performance-sessions")
public class PerformanceSessionController {
    private final PerformanceSessionService performanceSessionService;
    private final PerformanceSessionMapper performanceSessionMapper;

    public PerformanceSessionController(PerformanceSessionService performanceSessionService,
                                        PerformanceSessionMapper performanceSessionMapper) {
        this.performanceSessionService = performanceSessionService;
        this.performanceSessionMapper = performanceSessionMapper;
    }

    @PostMapping
    public void addPerformanceSession(@RequestBody @Valid PerformanceSessionRequestDto
                                                  performanceSessionRequestDto) {
        PerformanceSession performanceSession = performanceSessionMapper
                .mapToEntity(performanceSessionRequestDto);
        performanceSessionService.add(performanceSession);
    }

    @GetMapping("/available")
    public List<PerformanceSessionResponseDto> getAllAvailable(
            @RequestParam Long performanceId, @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy")
                    LocalDate date) {
        return performanceSessionService.findAvailableSessions(performanceId, date)
                .stream()
                .map(performanceSessionMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void updateSession(@PathVariable Long id,
                              @RequestBody @Valid PerformanceSessionRequestDto
                                      performanceSessionRequestDto) {
        PerformanceSession performanceSession = performanceSessionMapper
                .mapToEntity(performanceSessionRequestDto);
        performanceSession.setId(id);
        performanceSessionService.update(performanceSession);
    }

    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable Long id) {
        performanceSessionService.delete(id);
    }
}
