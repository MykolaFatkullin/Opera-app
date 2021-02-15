package com.tickets.service.mapper;

public interface GenericDto<T, V, O> {
    T mapToDto(O object);

    O dtoToMap(V requestDto);
}
