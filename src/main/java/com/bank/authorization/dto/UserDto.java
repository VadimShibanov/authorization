package com.bank.authorization.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    @NotNull(message = "Password must not be null")
    private String password;

    @NotNull(message = "Profile_id must not be null")
    private int profile_id;

    @NotNull(message = "Username must not be null")
    private String username;
}
