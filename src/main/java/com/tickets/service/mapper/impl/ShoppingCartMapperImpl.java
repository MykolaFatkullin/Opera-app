package com.tickets.service.mapper.impl;

import com.tickets.model.ShoppingCart;
import com.tickets.model.Ticket;
import com.tickets.model.dto.ShoppingCartResponseDto;
import com.tickets.service.mapper.ShoppingCartMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartMapperImpl implements ShoppingCartMapper {
    @Override
    public ShoppingCartResponseDto mapToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setId(shoppingCart.getId());
        List<Long> ticketsId = shoppingCart.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        shoppingCartResponseDto.setTicketsId(ticketsId);
        return shoppingCartResponseDto;
    }
}
