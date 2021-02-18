package com.tickets.controller;

import com.tickets.model.User;
import com.tickets.model.dto.UserResponseDto;
import com.tickets.service.authentication.AuthenticationObjectProcessing;
import com.tickets.service.mapper.UserMapper;
import com.tickets.service.model.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final AuthenticationObjectProcessing authenticationObjectProcessing;

    public UserController(UserService userService, UserMapper userMapper,
                          AuthenticationObjectProcessing authenticationObjectProcessing) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.authenticationObjectProcessing = authenticationObjectProcessing;
    }

    @GetMapping("/by-email")
    public UserResponseDto getByEmail(Authentication authentication) {
        String email = authenticationObjectProcessing.getUsername(authentication);
        User user = userService.findByEmail(email).orElseThrow(RuntimeException::new);
        return userMapper.mapToDto(user);
    }
}
