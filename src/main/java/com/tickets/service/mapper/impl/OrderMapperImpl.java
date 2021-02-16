package com.tickets.service.mapper.impl;

import com.tickets.model.Order;
import com.tickets.model.Ticket;
import com.tickets.model.dto.OrderResponseDto;
import com.tickets.service.mapper.OrderMapper;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperImpl implements OrderMapper {
    private static final String DATE_FORMAT = "dd.MM.yyyy HH:mm";

    @Override
    public OrderResponseDto entityToMap(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        orderResponseDto.setOrderDate(order.getOrderDate().format(formatter));
        orderResponseDto.setId(order.getId());
        List<Long> ticketsId = order.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        orderResponseDto.setTicketsIds(ticketsId);
        return orderResponseDto;
    }
}
