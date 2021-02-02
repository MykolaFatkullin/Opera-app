package com.tickets.dao;

import com.tickets.model.User;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> getByEmail(String email);
}
