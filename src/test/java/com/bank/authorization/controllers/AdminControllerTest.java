package com.bank.authorization.controllers;

import com.bank.authorization.mapper.UserMapper;
import com.bank.authorization.model.Role;
import com.bank.authorization.model.User;
import com.bank.authorization.service.AuditService;
import com.bank.authorization.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
class AdminControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserServiceImpl userServiceImpl;

    @MockBean
    AuditService auditService;

    @Autowired
    UserMapper userMapper;

    @Test
    @WithMockUser(username = "admin")
    void getAll() throws Exception {

        when(userServiceImpl.getAllUsers()).thenReturn(List.of(
                new User(1l, "admin", "100", 1, Set.of(new Role("ROLE_ADMIN"), new Role("ROLE_USER"))),
                new User(2L, "user", "200", 2, Set.of(new Role("ROLE_USER")))));


        mockMvc.perform(get("/bank/admin/getAllUsers").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[*].id", containsInAnyOrder(1, 2)))
                .andExpect(jsonPath("$[*].username", containsInAnyOrder("admin", "user")));
    }

    @Test
    void deleteUser() throws Exception {

        User user = new User(1L, "admin", "100", 1, Set.of(new Role("ROLE_ADMIN"), new Role("ROLE_USER")));

        when(userServiceImpl.findOne(1l)).thenReturn(user);

        when(userServiceImpl.removeUserById(1L)).thenReturn(user);

        mockMvc.perform(get("/bank/admin/delete/{id}", user.getId()).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}