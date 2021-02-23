package com.opera.controller;

import com.opera.model.dto.OrderResponseDto;
import com.opera.service.mapper.OrderMapper;
import com.opera.service.model.OrderService;
import com.opera.service.model.ShoppingCartService;
import com.opera.service.model.UserService;
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

    public OrderController(OrderService orderService,
                           ShoppingCartService shoppingCartService, UserService userService,
                           OrderMapper orderMapper) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.orderMapper = orderMapper;
    }

    @PostMapping("/complete")
    public void completeOrder(Authentication authentication) {
        String email = authentication.getName();
        orderService.completeOrder(shoppingCartService.getByUser(userService.findByEmail(email)
                .orElseThrow(RuntimeException::new)));
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistory(Authentication authentication) {
        String email = authentication.getName();
        return orderService.getOrdersHistory(userService.findByEmail(email)
                .orElseThrow(RuntimeException::new))
                .stream()
                .map(orderMapper::mapToDto)
                .collect(Collectors.toList());
    }

}
