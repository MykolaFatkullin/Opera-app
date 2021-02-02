package com.tickets.security;

import com.tickets.exception.AuthenticationException;
import com.tickets.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password);
}
