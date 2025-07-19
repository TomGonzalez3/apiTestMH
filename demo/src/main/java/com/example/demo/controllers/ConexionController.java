package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ConexionController {

    @Value("${DB_USER}")
    private String dbUser;

    @Value("${DB_PASSWORD}")
    private String dbPassword;

    @GetMapping("/credenciales")
    public Map<String, String> getCredenciales() {
        Map<String, String> creds = new HashMap<>();
        creds.put("user", dbUser);
        creds.put("password", dbPassword);
        return creds;
    }
}

