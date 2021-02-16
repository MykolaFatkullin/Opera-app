package com.tickets.controller;

import com.tickets.model.dto.OrderResponseDto;
import com.tickets.service.mapper.OrderMapper;
import com.tickets.service.model.OrderService;
import com.tickets.service.model.ShoppingCartService;
import com.tickets.service.model.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public void completeOrder(@RequestParam Long userId) {
        orderService.completeOrder(shoppingCartService.getByUser(userService.getById(userId)));
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistory(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.getById(userId))
                .stream()
                .map(orderMapper::entityToMap)
                .collect(Collectors.toList());
    }
}
