package com.bank.authorization.service;

import com.bank.authorization.model.Role;
import com.bank.authorization.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.any;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {
    @Mock
    RoleRepository roleRepository;

    @InjectMocks
    RoleServiceImpl roleServiceImpl;

    @Test
    void listRoles() {

        List<Role> expectedRoles = List.of(
                new Role("ROLE_ADMIN"),
                new Role("ROLE_USER"));

        when(roleRepository.findAll()).thenReturn(expectedRoles);

        List<Role> actualRoles = roleServiceImpl.listRoles();

        assertEquals(expectedRoles, actualRoles);

    }

    @Test
    void saveRole() {

        Role expectedRole = new Role("ROLE_ADMIN");

        when(roleRepository.save(any())).thenReturn(expectedRole);

        Role actualRole = roleServiceImpl.saveRole(expectedRole);

        assertEquals(expectedRole, actualRole);

    }

}
