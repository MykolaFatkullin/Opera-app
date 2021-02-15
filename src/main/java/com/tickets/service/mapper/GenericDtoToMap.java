package com.tickets.service.mapper;

public interface GenericDtoToMap<T, V> {
    V dtoToMap(T requestDto);
}
