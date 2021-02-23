package com.tickets.security.impl;

import com.tickets.model.User;
import com.tickets.security.AuthenticationService;
import com.tickets.service.model.RoleService;
import com.tickets.service.model.ShoppingCartService;
import com.tickets.service.model.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {

        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public void register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(List.of(roleService.getRoleByName("USER")));
        User newUser = userService.add(user);
        shoppingCartService.registerNewShoppingCart(newUser);
    }
}
