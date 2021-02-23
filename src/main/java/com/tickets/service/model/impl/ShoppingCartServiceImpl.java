package com.tickets.service.model.impl;

import com.tickets.dao.ShoppingCartDao;
import com.tickets.dao.TicketDao;
import com.tickets.model.PerformanceSession;
import com.tickets.model.ShoppingCart;
import com.tickets.model.Ticket;
import com.tickets.model.User;
import com.tickets.service.model.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartDao shoppingCartDao;
    private final TicketDao ticketDao;

    public ShoppingCartServiceImpl(ShoppingCartDao shoppingCartDao, TicketDao ticketDao) {
        this.shoppingCartDao = shoppingCartDao;
        this.ticketDao = ticketDao;
    }

    @Override
    public void addSession(PerformanceSession performanceSession, User user) {
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setMovieSession(performanceSession);
        ShoppingCart byUser = shoppingCartDao.getByUser(user);
        byUser.getTickets().add(ticket);
        ticketDao.add(ticket);
        shoppingCartDao.update(byUser);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartDao.add(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.getTickets().clear();
        shoppingCartDao.update(shoppingCart);
    }
}
