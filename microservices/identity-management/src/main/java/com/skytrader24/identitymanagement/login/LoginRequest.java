package com.skytrader24.identitymanagement.login;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Validated
public record LoginRequest(
        @NotBlank(message = "username cannot be empty")
        @Size(max = 50, message = "The username can contain up to 50 characters")
        String username,

        @NotBlank(message = "The password cannot be empty")
        @Size(min = 6, max = 20, message = "The password should be between 6 and 20 characters long")
        String password
) {}