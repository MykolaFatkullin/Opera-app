package com.tickets.service.model;

import com.tickets.model.Order;
import com.tickets.model.ShoppingCart;
import com.tickets.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
