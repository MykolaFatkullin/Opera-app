package com.tickets.security.impl;

import static com.tickets.util.HashUtil.hashPassword;

import com.tickets.exception.AuthenticationException;
import com.tickets.lib.Inject;
import com.tickets.lib.Service;
import com.tickets.model.User;
import com.tickets.security.AuthenticationService;
import com.tickets.service.ShoppingCartService;
import com.tickets.service.UserService;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        Optional<User> userFromDb = userService.findByEmail(email);
        if (userFromDb.isPresent() && userFromDb.get().getPassword().equals(hashPassword(password,
                userFromDb.get().getSalt()))) {
            return userFromDb.get();
        }
        throw new AuthenticationException("Incorrect email or password");
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        User newUser = userService.add(user);
        shoppingCartService.registerNewShoppingCart(newUser);
        return newUser;
    }
}
