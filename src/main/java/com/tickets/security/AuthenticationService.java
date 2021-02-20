package com.tickets.security;

import com.tickets.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
