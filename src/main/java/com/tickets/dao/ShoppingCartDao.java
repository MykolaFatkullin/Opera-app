package com.tickets.dao;

import com.tickets.model.ShoppingCart;
import com.tickets.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
