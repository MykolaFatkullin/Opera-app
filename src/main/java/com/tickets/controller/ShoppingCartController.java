package com.tickets.controller;

import com.tickets.model.ShoppingCart;
import com.tickets.model.dto.ShoppingCartResponseDto;
import com.tickets.service.authentication.AuthenticationObjectProcessing;
import com.tickets.service.mapper.ShoppingCartMapper;
import com.tickets.service.model.MovieSessionService;
import com.tickets.service.model.ShoppingCartService;
import com.tickets.service.model.UserService;
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
    private final MovieSessionService movieSessionService;
    private final AuthenticationObjectProcessing authenticationObjectProcessing;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ShoppingCartMapper shoppingCartMapper, UserService userService,
                                  MovieSessionService movieSessionService,
                                  AuthenticationObjectProcessing authenticationObjectProcessing) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartMapper = shoppingCartMapper;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
        this.authenticationObjectProcessing = authenticationObjectProcessing;
    }

    @PostMapping("/movie-sessions")
    public void addMovieSession(@RequestParam Long movieSessionId, Authentication authentication) {
        String email = authenticationObjectProcessing.getUsername(authentication);
        shoppingCartService.addSession(movieSessionService.getById(movieSessionId),
                userService.findByEmail(email).orElseThrow(RuntimeException::new));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication authentication) {
        String email = authenticationObjectProcessing.getUsername(authentication);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(userService.findByEmail(email)
                .orElseThrow(RuntimeException::new));
        return shoppingCartMapper.mapToDto(shoppingCart);
    }
}
