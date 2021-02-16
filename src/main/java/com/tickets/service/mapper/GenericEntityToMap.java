package com.tickets.service.mapper;

public interface GenericEntityToMap<T, V> {
    T entityToMap(V value);
}
