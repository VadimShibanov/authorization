package com.bank.authorization.service;

import com.bank.authorization.model.Role;
import com.bank.authorization.model.User;
import com.bank.authorization.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Test
    void getAllUsers() {

        List<User> expectedUsers = List.of(
                new User("100", Set.of(new Role("ROLE_ADMIN"), new Role("ROLE_USER")), 1, "admin"),
                new User("200", Set.of(new Role("ROLE_USER")), 2, "user")
        );

        when(userRepository.findAll()).thenReturn(expectedUsers);

        List<User> actualUsers = userServiceImpl.getAllUsers();

        assertEquals(expectedUsers, actualUsers);

    }

    @Test
    void findOne() {

        User expectedUser = new User(1L, "admin", "100", 1, Set.of(new Role("ROLE_ADMIN"), new Role("ROLE_USER")));

        when(userRepository.findById(1L)).thenReturn(Optional.of(expectedUser));

        User actualUser = userServiceImpl.findOne(1L);

        assertEquals(expectedUser, actualUser);

    }

    @Test
    void findByUsername() {

        User expectedUser = new User(1L, "admin", "100", 1, Set.of(new Role("ROLE_ADMIN"), new Role("ROLE_USER")));

        when(userRepository.getByUsername("admin")).thenReturn(expectedUser);

        User actualUser = userServiceImpl.findByUsername("admin");

        assertEquals(expectedUser, actualUser);

    }

    @Test
    void removeUserById() {

        User expectedUser = new User(1L, "admin", "100", 1, Set.of(new Role("ROLE_ADMIN"), new Role("ROLE_USER")));

        when(userRepository.findById(1L)).thenReturn(Optional.of(expectedUser));

        User actualUser = userServiceImpl.removeUserById(1l);

        assertEquals(expectedUser, actualUser);

    }

    @Test
    void saveUserTest() {

        User expectedUser = new User(1L, "admin", "100", 1, Set.of(new Role("ROLE_ADMIN"), new Role("ROLE_USER")));

        when(userRepository.save(expectedUser)).thenReturn(expectedUser);

        User actualUser = userServiceImpl.saveUser(expectedUser);

        assertEquals(expectedUser, actualUser);

    }
}
