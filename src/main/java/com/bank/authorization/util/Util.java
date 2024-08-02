package com.bank.authorization.util;

import com.bank.authorization.config.Password;
import com.bank.authorization.model.Role;
import com.bank.authorization.model.User;
import com.bank.authorization.service.RoleService;
import com.bank.authorization.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@AllArgsConstructor
public class Util {
    private final RoleService roleService;
    private final UserService userService;
    private final Password password;

    @PostConstruct
    public void initialization() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");

        if (roleService.listRoles().isEmpty()) {
            roleService.saveRole(roleAdmin);
            roleService.saveRole(roleUser);
        }

        User admin = new User("100", Set.of(roleAdmin, roleUser), 1, "admin");
        admin.setPassword(password.bCryptPasswordEncoder().encode(admin.getPassword()));
        userService.saveUser(admin);

        User user = new User("200", Set.of(roleUser), 2, "user");
        user.setPassword(password.bCryptPasswordEncoder().encode(user.getPassword()));
        userService.saveUser(user);
    }
}
