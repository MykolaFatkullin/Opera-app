package com.tickets.service.mapper.impl;

import com.tickets.model.Stage;
import com.tickets.model.dto.StageRequestDto;
import com.tickets.model.dto.StageResponseDto;
import com.tickets.service.mapper.StageMapper;
import org.springframework.stereotype.Component;

@Component
public class StageMapperImpl implements StageMapper {

    @Override
    public StageResponseDto mapToDto(Stage stage) {
        StageResponseDto stageResponseDto = new StageResponseDto();
        stageResponseDto.setId(stage.getId());
        stageResponseDto.setCapacity(stage.getCapacity());
        stageResponseDto.setDescription(stage.getDescription());
        return stageResponseDto;
    }

    @Override
    public Stage mapToEntity(StageRequestDto stageRequestDto) {
        Stage stage = new Stage();
        stage.setCapacity(stageRequestDto.getCapacity());
        stage.setDescription(stageRequestDto.getDescription());
        return stage;
    }
}
