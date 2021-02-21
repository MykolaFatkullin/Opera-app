package com.tickets.security.impl;

import static org.springframework.security.core.userdetails.User.withUsername;

import com.tickets.model.User;
import com.tickets.service.model.UserService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("Can't find user with email: " + email));
        UserBuilder userBuilder = withUsername(email);
        userBuilder.password(user.getPassword());
        String[] roles = user.getRoles()
                .stream()
                .map(role -> role.getRoles().toString())
                .toArray(String[]::new);
        userBuilder.roles(roles);
        return userBuilder.build();
    }
}
