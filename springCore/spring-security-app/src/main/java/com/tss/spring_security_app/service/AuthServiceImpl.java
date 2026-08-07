package com.tss.spring_security_app.service;

import com.tss.spring_security_app.dto.JwtResponseDto;
import com.tss.spring_security_app.dto.LoginDto;
import com.tss.spring_security_app.dto.RegistrationDto;
import com.tss.spring_security_app.dto.UserResponseDto;
import com.tss.spring_security_app.entity.Role;
import com.tss.spring_security_app.entity.User;
import com.tss.spring_security_app.exception.UserApiException;
import com.tss.spring_security_app.repository.RoleRepository;
import com.tss.spring_security_app.repository.UserRepository;
import com.tss.spring_security_app.security.JWTTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTTokenProvider tokenProvider;

    @Override
    public UserResponseDto register(RegistrationDto registrationDto) {

        if (userRepository.existsByUserName(registrationDto.getUserName())) {
            throw new UserApiException(HttpStatus.BAD_REQUEST,
                    "Username already exists");
        }

        Role role = roleRepository.findByRoleName(registrationDto.getRole())
                .orElseThrow(() -> new UserApiException(HttpStatus.NOT_FOUND, "Role not found"));

        User user = new User();
        user.setUserName(registrationDto.getUserName());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setRole(role);

        User savedUser = userRepository.save(user);

        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setUserId(savedUser.getUserId());
        responseDto.setUserName(savedUser.getUserName());

        return responseDto;
    }

    @Override
    public JwtResponseDto login(LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getUserName(),
                            loginDto.getPassword())
            );

            String token = tokenProvider.generateToken(authentication);

            return new JwtResponseDto(token);

        } catch (BadCredentialsException e) {
            throw new UserApiException(
                    HttpStatus.UNAUTHORIZED,
                    "Username or password is incorrect");
        }
    }
}
