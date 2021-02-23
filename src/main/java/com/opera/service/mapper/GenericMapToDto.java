package com.opera.service.mapper;

public interface GenericMapToDto<T, V> {
    T mapToDto(V value);
}
