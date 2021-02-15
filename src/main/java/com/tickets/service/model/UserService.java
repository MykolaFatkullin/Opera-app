package com.tickets.service.model;

import com.tickets.model.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);

    User getById(Long id);
}
