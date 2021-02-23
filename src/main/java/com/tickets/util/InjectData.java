package com.tickets.util;

import com.tickets.model.Role;
import com.tickets.model.Roles;
import com.tickets.model.User;
import com.tickets.service.model.RoleService;
import com.tickets.service.model.ShoppingCartService;
import com.tickets.service.model.UserService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class InjectData {
    private final RoleService roleService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public InjectData(RoleService roleService, UserService userService,
                      ShoppingCartService shoppingCartService) {
        this.roleService = roleService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @PostConstruct
    public void init() {
        Role admin = new Role();
        admin.setRole(Roles.ADMIN);
        Role user = new Role();
        user.setRole(Roles.USER);
        roleService.add(admin);
        roleService.add(user);
        User userAdmin = new User();
        userAdmin.setEmail("admin@example.com");
        userAdmin.setPassword("1234");
        userAdmin.setRoles(List.of(admin));
        shoppingCartService.registerNewShoppingCart(userService.add(userAdmin));
    }
}
