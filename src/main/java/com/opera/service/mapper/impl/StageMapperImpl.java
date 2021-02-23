package com.opera.service.mapper.impl;

import com.opera.model.Stage;
import com.opera.model.dto.StageRequestDto;
import com.opera.model.dto.StageResponseDto;
import com.opera.service.mapper.StageMapper;
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
