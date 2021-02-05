package com.tickets.service.impl;

import com.tickets.dao.OrderDao;
import com.tickets.lib.Inject;
import com.tickets.lib.Service;
import com.tickets.model.Order;
import com.tickets.model.ShoppingCart;
import com.tickets.model.Ticket;
import com.tickets.model.User;
import com.tickets.service.OrderService;
import com.tickets.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private ShoppingCartService shoppingCartService;
    @Inject
    private OrderDao orderDao;

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        List<Ticket> tickets = shoppingCart.getTickets();
        order.setTickets(new ArrayList<>(tickets));
        order.setOrderDate(LocalDateTime.now());
        order.setUser(shoppingCart.getUser());
        orderDao.add(order);
        shoppingCartService.clear(shoppingCart);
        return order;
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getOrdersHistory(user);
    }
}
