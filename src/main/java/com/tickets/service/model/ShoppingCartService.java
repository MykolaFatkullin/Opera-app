package com.tickets.service.model;

import com.tickets.model.PerformanceSession;
import com.tickets.model.ShoppingCart;
import com.tickets.model.User;

public interface ShoppingCartService {
    void addSession(PerformanceSession performanceSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
