package com.tickets;

import com.tickets.dao.TicketDao;
import com.tickets.exception.AuthenticationException;
import com.tickets.lib.Injector;
import com.tickets.model.CinemaHall;
import com.tickets.model.Movie;
import com.tickets.model.MovieSession;
import com.tickets.model.Ticket;
import com.tickets.model.User;
import com.tickets.security.AuthenticationService;
import com.tickets.service.CinemaHallService;
import com.tickets.service.MovieService;
import com.tickets.service.MovieSessionService;
import com.tickets.service.ShoppingCartService;
import java.time.LocalDateTime;

public class Main {
    private static final Injector injector = Injector.getInstance("com.tickets");

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        movie.setDescription("is a media franchise centered on a series of action films that "
                + "are largely concerned with illegal street racing, heists and spies");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        movieService.add(movie);

        movieService.getAll().forEach(System.out::println);

        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(100);
        cinemaHall.setDescription("Red hall");
        CinemaHallService cinemaHallService
                = (CinemaHallService) injector.getInstance(CinemaHallService.class);
        cinemaHallService.add(cinemaHall);

        cinemaHallService.getAll().forEach(System.out::println);

        MovieSession movieSession = new MovieSession();
        LocalDateTime filmTime
                = LocalDateTime.of(2020, 1, 31, 22, 30);
        movieSession.setMovie(movie);
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setShowTime(filmTime);
        MovieSessionService movieSessionService
                = (MovieSessionService) injector.getInstance(MovieSessionService.class);
        movieSessionService.add(movieSession);
        System.out.println(movieSessionService
                .findAvailableSessions(movie.getId(), filmTime.toLocalDate()));

        AuthenticationService authenticationService = (AuthenticationService) injector
                .getInstance(AuthenticationService.class);
        User user = authenticationService.register("example@gmail.com", "qwerty");
        System.out.println(user);
        System.out.println(authenticationService.register("example2@gmail.com", "qwerty"));
        try {
            System.out.println(authenticationService.login("example2@gmail.com", "qwerty"));
        } catch (AuthenticationException e) {
            throw new RuntimeException("Incorrect email or password", e);
        }
        Ticket ticket = new Ticket();
        ticket.setMovieSession(movieSession);
        TicketDao ticketDao = (TicketDao) injector.getInstance(TicketDao.class);
        System.out.println(ticketDao.add(ticket));

        ShoppingCartService shoppingCartService = (ShoppingCartService) injector
                .getInstance(ShoppingCartService.class);
        shoppingCartService.addSession(movieSession, user);
        System.out.println(shoppingCartService.getByUser(user));
    }
}
