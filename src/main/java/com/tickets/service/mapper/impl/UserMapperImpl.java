package com.tickets.service.mapper.impl;

import com.tickets.model.User;
import com.tickets.model.dto.UserResponseDto;
import com.tickets.service.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponseDto entityToMap(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }
}
