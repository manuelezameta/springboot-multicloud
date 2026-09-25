package com.elmanusoft.client_api.controller;

import com.elmanusoft.client_api.dto.ClientRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @GetMapping(value="/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello from ClientController!");
    }

    @GetMapping(value="/error")
    public ResponseEntity<String> error() {
        return ResponseEntity.status(500).body("Error from ClientController!");
    }

    @PostMapping
    public ResponseEntity<String> createClient(@Valid @RequestBody ClientRequest clientRequest) {
        return ResponseEntity.ok("Client created successfully!");
    }

}
