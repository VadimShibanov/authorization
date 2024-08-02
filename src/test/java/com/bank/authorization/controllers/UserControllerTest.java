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
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserServiceImpl userServiceImpl;

    @MockBean
    AuditService auditService;

    @Autowired
    UserMapper userMapper;

    @Test
    @WithMockUser(username = "user")
    void getUser() throws Exception {
        when(userServiceImpl.findByUsername("user")).thenReturn(new User(2L, "user", "200", 2, Set.of(new Role("ROLE_USER"))));

        mockMvc.perform(get("/bank/user").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}