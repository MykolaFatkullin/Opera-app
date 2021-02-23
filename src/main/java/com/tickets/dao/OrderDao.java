package com.tickets.dao;

import com.tickets.model.Order;
import com.tickets.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
