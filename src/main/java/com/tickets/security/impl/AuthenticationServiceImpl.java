package com.tickets.security.impl;

import static com.tickets.util.HashUtil.hashPassword;

import com.tickets.exception.AuthenticationException;
import com.tickets.lib.Inject;
import com.tickets.lib.Service;
import com.tickets.model.User;
import com.tickets.security.AuthenticationService;
import com.tickets.service.UserService;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;

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
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);
        return userService.add(newUser);
    }
}
