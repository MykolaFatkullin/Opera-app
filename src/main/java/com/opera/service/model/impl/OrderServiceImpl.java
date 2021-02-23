package com.opera.service.model.impl;

import com.opera.dao.OrderDao;
import com.opera.model.Order;
import com.opera.model.ShoppingCart;
import com.opera.model.Ticket;
import com.opera.model.User;
import com.opera.service.model.OrderService;
import com.opera.service.model.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final ShoppingCartService shoppingCartService;
    private final OrderDao orderDao;

    public OrderServiceImpl(ShoppingCartService shoppingCartService, OrderDao orderDao) {
        this.shoppingCartService = shoppingCartService;
        this.orderDao = orderDao;
    }

    @Override
    public void completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        List<Ticket> tickets = shoppingCart.getTickets();
        order.setTickets(new ArrayList<>(tickets));
        order.setOrderDate(LocalDateTime.now());
        order.setUser(shoppingCart.getUser());
        orderDao.add(order);
        shoppingCartService.clear(shoppingCart);
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getOrdersHistory(user);
    }
}
