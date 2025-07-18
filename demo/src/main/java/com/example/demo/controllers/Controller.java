package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {
    @Value("${DB_CONNECTION}")
    private String dbConnection;

    @Value("${API_SECRET}")
    private String apiSecret;

    @PostMapping("/getConnection")
    public ResponseEntity<?> getConnection(@RequestHeader("Authorization") String authHeader) {
        if (!authHeader.equals("Bearer " + apiSecret)) {
            return ResponseEntity.status(401).body("Unauthorized");
        }

        return ResponseEntity.ok().body("{\"connectionString\": \"" + dbConnection + "\"}");
    }
}
