package com.tss.security_demo.service;

import com.tss.security_demo.dto.LoginRequestDto;
import com.tss.security_demo.dto.LoginResponseDto;
import com.tss.security_demo.dto.RegisterRequestDto;
import com.tss.security_demo.dto.RegisterResponseDto;

public interface AuthService {

    RegisterResponseDto registration(RegisterRequestDto register);

    LoginResponseDto login(LoginRequestDto login);
}
