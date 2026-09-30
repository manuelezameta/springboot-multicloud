package com.elmanusoft.client_api.dto;

import com.elmanusoft.client_api.model.Status;

public record ClientResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        Status status
) {
}
