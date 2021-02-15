package com.tickets.service.mapper.impl;

import com.tickets.model.Order;
import com.tickets.model.Ticket;
import com.tickets.model.dto.OrderResponseDto;
import com.tickets.service.mapper.OrderMapper;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class OrderMapperImpl implements OrderMapper {
    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        orderResponseDto.setOrderDate(order.getOrderDate().format(formatter));
        orderResponseDto.setId(order.getId());
        List<Long> ticketsId = order.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        orderResponseDto.setTicketsId(ticketsId);
        return orderResponseDto;
    }
}
