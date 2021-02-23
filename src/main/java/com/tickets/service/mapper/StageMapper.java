package com.tickets.service.mapper;

import com.tickets.model.Stage;
import com.tickets.model.dto.StageRequestDto;
import com.tickets.model.dto.StageResponseDto;

public interface StageMapper extends GenericMapToDto
        <StageResponseDto, Stage>, GenericMapToEntity<StageRequestDto, Stage> {

}
