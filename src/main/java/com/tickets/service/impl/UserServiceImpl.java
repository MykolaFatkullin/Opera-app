package com.tickets.service.impl;

import com.tickets.dao.UserDao;
import com.tickets.lib.Inject;
import com.tickets.lib.Service;
import com.tickets.model.User;
import com.tickets.service.UserService;
import com.tickets.util.HashUtil;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Override
    public User add(User user) {
        byte[] salt = HashUtil.getSalt();
        user.setSalt(salt);
        String hashedPassword = HashUtil.hashPassword(user.getPassword(), salt);
        user.setPassword(hashedPassword);
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.getByEmail(email);
    }
}
