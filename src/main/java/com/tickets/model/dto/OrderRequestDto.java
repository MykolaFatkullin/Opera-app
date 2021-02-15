package com.tickets.model.dto;

import java.util.List;

public class OrderRequestDto {
    private List<Long> ticketsId;

    public List<Long> getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(List<Long> ticketsId) {
        this.ticketsId = ticketsId;
    }
}
