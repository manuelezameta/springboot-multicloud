package com.elmanusoft.client_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ClientRequest(
        @NotBlank(message = "Name is required")
        String name,
        @Email(message = "Email should be valid")
        String email,
        @NotBlank(message = "Phone number is required")
        String phoneNumber,
        @Positive(message = "Age must be a positive number")
        Integer age
) {
}
