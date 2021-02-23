package com.opera.service.mapper;

import com.opera.model.Stage;
import com.opera.model.dto.StageRequestDto;
import com.opera.model.dto.StageResponseDto;

public interface StageMapper extends GenericMapToDto
        <StageResponseDto, Stage>, GenericMapToEntity<StageRequestDto, Stage> {

}
