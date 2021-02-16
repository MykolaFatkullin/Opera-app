package com.tickets.service.mapper;

import com.tickets.model.ShoppingCart;
import com.tickets.model.dto.ShoppingCartResponseDto;

public interface ShoppingCartMapper extends
        GenericMapToDto<ShoppingCartResponseDto, ShoppingCart> {
}
