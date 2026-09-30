package com.elmanusoft.client_api.dto;

import com.elmanusoft.client_api.model.Status;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ClientRequest(
        @NotBlank(message = "First name is required")
        @Schema(description = "The first name of the client", example = "John")
        String firstName,

        @NotBlank(message = "Last name is required")
        @Schema(description = "The last name of the client", example = "Doe")
        String lastName,

        @Email(message = "Email should be valid")
        @NotBlank(message = "Email is required")
        @Schema(description = "The email address of the client", example = "john.doe@example.com")
        String email,

        @Schema(description = "The status of the client", example = "ACTIVE")
        Status status
) {
}
