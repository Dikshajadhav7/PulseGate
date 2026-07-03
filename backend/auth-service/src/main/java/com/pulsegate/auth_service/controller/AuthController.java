package com.pulsegate.auth_service.controller;

import com.pulsegate.auth_service.dto.LoginRequest;
import com.pulsegate.auth_service.dto.LoginResponse;
import com.pulsegate.auth_service.dto.RegisterRequest;
import com.pulsegate.auth_service.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(
            @RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request) {

        return authService.login(request);
    }

    @GetMapping("/profile")
    public String profile() {

        return "Welcome to PulseGate Secure API";
    }
}