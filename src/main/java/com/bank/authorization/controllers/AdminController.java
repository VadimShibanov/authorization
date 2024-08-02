package com.bank.authorization.controllers;

import com.bank.authorization.dto.UserDto;
import com.bank.authorization.mapper.UserMapper;
import com.bank.authorization.service.AuditService;
import com.bank.authorization.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/bank/admin")
public class AdminController {

    private final UserService userService;

    private final UserMapper userMapper;

    private final AuditService auditService;

    @Operation(summary = "Get all users")
    @GetMapping("/getAllUsers")
    public List<UserDto> getAll(Principal principal) {
        auditService.auditGetAll(userService.findByUsername(principal.getName()));
        return userMapper.toUserDtoList(userService.getAllUsers());
    }
    @Operation(summary = "Delete particular user")
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        if ((userService.findOne(id)) != null) {
            auditService.auditDelete(userService.findOne(id));
            userService.removeUserById(id);
            return "Пользователь удален";
        } else
            return "Пользователь не найден";
    }
}
