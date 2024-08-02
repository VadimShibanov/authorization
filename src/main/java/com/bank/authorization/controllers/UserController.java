package com.bank.authorization.controllers;

import com.bank.authorization.dto.UserDto;
import com.bank.authorization.mapper.UserMapper;
import com.bank.authorization.service.AuditService;
import com.bank.authorization.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
@AllArgsConstructor
@RequestMapping("/bank/user")
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    private final AuditService auditService;

    @Operation(summary = "Get information about user")
    @GetMapping
    public UserDto getUser(Principal principal) {
        auditService.auditGet(userService.findByUsername(principal.getName()));
        return userMapper.toUserDto(userService.findByUsername(principal.getName()));
    }
}
