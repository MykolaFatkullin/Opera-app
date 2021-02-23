package com.opera.service.mapper;

public interface GenericMapToEntity<T, V> {
    V mapToEntity(T requestDto);
}
