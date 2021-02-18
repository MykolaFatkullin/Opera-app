package com.tickets.controller;

import com.tickets.model.dto.OrderResponseDto;
import com.tickets.service.authentication.AuthenticationObjectProcessing;
import com.tickets.service.mapper.OrderMapper;
import com.tickets.service.model.OrderService;
import com.tickets.service.model.ShoppingCartService;
import com.tickets.service.model.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final OrderMapper orderMapper;
    private final AuthenticationObjectProcessing authenticationObjectProcessing;

    public OrderController(OrderService orderService,
                           ShoppingCartService shoppingCartService, UserService userService,
                           OrderMapper orderMapper,
                           AuthenticationObjectProcessing authenticationObjectProcessing) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.orderMapper = orderMapper;
        this.authenticationObjectProcessing = authenticationObjectProcessing;
    }

    @PostMapping("/complete")
    public void completeOrder(Authentication authentication) {
        String email = authenticationObjectProcessing.getUsername(authentication);
        orderService.completeOrder(shoppingCartService.getByUser(userService.findByEmail(email)
                .orElseThrow(RuntimeException::new)));
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistory(Authentication authentication) {
        String email = authenticationObjectProcessing.getUsername(authentication);
        return orderService.getOrdersHistory(userService.findByEmail(email)
                .orElseThrow(RuntimeException::new))
                .stream()
                .map(orderMapper::mapToDto)
                .collect(Collectors.toList());
    }

}
