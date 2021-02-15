package com.tickets.service.model.impl;

import com.tickets.dao.UserDao;
import com.tickets.model.User;
import com.tickets.service.model.UserService;
import com.tickets.util.HashUtil;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

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

    @Override
    public User getById(Long id) {
        return userDao.getById(id).orElseThrow(RuntimeException::new);
    }
}
