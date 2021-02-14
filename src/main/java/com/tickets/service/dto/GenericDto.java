package com.tickets.service.dto;

public interface GenericDto<T, V, O> {
    T mapToDto(O object);

    O dtoToMap(V requestDto);
}
