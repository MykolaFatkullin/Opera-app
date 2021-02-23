package com.opera.controller;

import com.opera.model.ShoppingCart;
import com.opera.model.dto.ShoppingCartResponseDto;
import com.opera.service.mapper.ShoppingCartMapper;
import com.opera.service.model.PerformanceSessionService;
import com.opera.service.model.ShoppingCartService;
import com.opera.service.model.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartMapper shoppingCartMapper;
    private final UserService userService;
    private final PerformanceSessionService performanceSessionService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ShoppingCartMapper shoppingCartMapper, UserService userService,
                                  PerformanceSessionService performanceSessionService) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartMapper = shoppingCartMapper;
        this.userService = userService;
        this.performanceSessionService = performanceSessionService;
    }

    @PostMapping("/performance-sessions")
    public void addPerformanceSession(@RequestParam Long performanceSessionId,
                                      Authentication authentication) {
        String email = authentication.getName();
        shoppingCartService.addSession(performanceSessionService.getById(performanceSessionId),
                userService.findByEmail(email).orElseThrow(RuntimeException::new));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication authentication) {
        String email = authentication.getName();
        ShoppingCart shoppingCart = shoppingCartService.getByUser(userService.findByEmail(email)
                .orElseThrow(RuntimeException::new));
        return shoppingCartMapper.mapToDto(shoppingCart);
    }
}
