package com.tickets.controller;

import com.tickets.model.Stage;
import com.tickets.model.dto.StageRequestDto;
import com.tickets.model.dto.StageResponseDto;
import com.tickets.service.mapper.StageMapper;
import com.tickets.service.model.StageService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stages")
public class StageController {
    private final StageService stageService;
    private final StageMapper stageMapper;

    public StageController(StageService stageService,
                           StageMapper stageMapper) {
        this.stageService = stageService;
        this.stageMapper = stageMapper;
    }

    @PostMapping
    public void addStage(@RequestBody @Valid StageRequestDto stageRequestDto) {
        Stage stage = stageMapper.mapToEntity(stageRequestDto);
        stageService.add(stage);
    }

    @GetMapping
    public List<StageResponseDto> getAll() {
        return stageService.getAll()
                .stream()
                .map(stageMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
