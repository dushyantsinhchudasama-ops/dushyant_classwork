package com.tss.spring_security_app.service;

import com.tss.spring_security_app.dto.JwtResponseDto;
import com.tss.spring_security_app.dto.LoginDto;
import com.tss.spring_security_app.dto.RegistrationDto;
import com.tss.spring_security_app.dto.UserResponseDto;

public interface AuthService {

    UserResponseDto register(RegistrationDto registrationDto);
    JwtResponseDto login (LoginDto loginDto);
}
