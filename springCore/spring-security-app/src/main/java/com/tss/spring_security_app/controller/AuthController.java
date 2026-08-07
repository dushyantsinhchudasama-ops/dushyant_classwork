package com.tss.spring_security_app.controller;

import com.tss.spring_security_app.dto.JwtResponseDto;
import com.tss.spring_security_app.dto.LoginDto;
import com.tss.spring_security_app.dto.RegistrationDto;
import com.tss.spring_security_app.dto.UserResponseDto;
import com.tss.spring_security_app.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(
            @Valid @RequestBody RegistrationDto registrationDto) {

        UserResponseDto response = authService.register(registrationDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(
            @Valid @RequestBody LoginDto loginDto) {

        JwtResponseDto jwtResponse = authService.login(loginDto);
        return ResponseEntity.ok(jwtResponse);
    }
}