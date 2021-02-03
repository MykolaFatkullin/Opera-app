package com.tickets.service.impl;

import com.tickets.dao.ShoppingCartDao;
import com.tickets.dao.TicketDao;
import com.tickets.lib.Inject;
import com.tickets.lib.Service;
import com.tickets.model.MovieSession;
import com.tickets.model.ShoppingCart;
import com.tickets.model.Ticket;
import com.tickets.model.User;
import com.tickets.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Inject
    private ShoppingCartDao shoppingCartDao;

    @Inject
    private TicketDao ticketDao;

    @Override
    public void addSession(MovieSession movieSession, User user) {
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setMovieSession(movieSession);
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
