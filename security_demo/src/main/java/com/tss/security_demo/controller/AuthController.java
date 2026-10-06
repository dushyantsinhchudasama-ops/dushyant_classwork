package com.tss.security_demo.controller;

import com.tss.security_demo.dto.LoginRequestDto;
import com.tss.security_demo.dto.LoginResponseDto;
import com.tss.security_demo.dto.RegisterRequestDto;
import com.tss.security_demo.dto.RegisterResponseDto;
import com.tss.security_demo.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@Valid @RequestBody RegisterRequestDto register) {
        RegisterResponseDto response = authService.registration(register);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto login)
    {
        LoginResponseDto loginRespone = authService.login(login);

        return new ResponseEntity<>(loginRespone, HttpStatus.OK);
    }
}
