package com.tickets.service.mapper.impl;

import com.tickets.model.Order;
import com.tickets.model.Ticket;
import com.tickets.model.dto.OrderResponseDto;
import com.tickets.service.mapper.OrderMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderDate(order.getOrderDate());
        orderResponseDto.setId(order.getId());
        List<Long> ticketIds = order.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        orderResponseDto.setTicketsIds(ticketIds);
        return orderResponseDto;
    }
}
