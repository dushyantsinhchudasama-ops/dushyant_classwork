package com.tss.security_demo.service.impl;

import com.tss.security_demo.dto.LoginRequestDto;
import com.tss.security_demo.dto.LoginResponseDto;
import com.tss.security_demo.dto.RegisterRequestDto;
import com.tss.security_demo.dto.RegisterResponseDto;
import com.tss.security_demo.entity.User;
import com.tss.security_demo.entity.UserRole;
import com.tss.security_demo.exception.AccountLockedException;
import com.tss.security_demo.exception.DuplicateResourceException;
import com.tss.security_demo.exception.InvalidCredentialsException;
import com.tss.security_demo.repository.UserRepository;
import com.tss.security_demo.security.CustomeUserDetails;
import com.tss.security_demo.security.JwtTokenProvider;
import com.tss.security_demo.service.AuthService;
import com.tss.security_demo.util.NormalizationUtils;
import lombok.RequiredArgsConstructor;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    //variables to check account locked until time and max failed login account
    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final int LOCK_DURATION_MINUTES = 5;

    @Override
    public RegisterResponseDto registration(RegisterRequestDto register) {

        String passwordHash = passwordEncoder.encode(register.getPassword());

        User user = new User();

        user.setRole(UserRole.USER);
        user.setUsername(register.getUsername());
        user.setPasswordHash(passwordHash);
        user.setIsActive(true);
        user.setFailedLoginCount(0);
        user.setLockedUntil(null);

        try {
            User savedUser = userRepository.save(user);

            RegisterResponseDto registeredUser = new RegisterResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getRole().name());
            return registeredUser;

        } catch (DataIntegrityViolationException e)
        {
            throw new DuplicateResourceException("Email already exist!");
        }

    }

    @Override
    public LoginResponseDto login(LoginRequestDto login) {

        User user = userRepository
                .findByUsername(login.getEmail())
                .orElseThrow(() -> new InvalidCredentialsException("Invalid Email or password"));

        LocalDateTime now = LocalDateTime.now();

        //first checking weather the account is currently locked or not

        if (user.getLockedUntil() != null) {

            //if user is currently locked
            if (user.getLockedUntil().isAfter(now)) {
                throw new AccountLockedException("Account is temporarily Locked. Please try again after sometime!");
            }

            //if lock has expired
            user.setLockedUntil(null);
            user.setFailedLoginCount(0);
            userRepository.save(user);
        }

        //if entered password is incorrect
        boolean passwordMatches = passwordEncoder.matches(login.getPassword(), user.getPasswordHash());

        if (!passwordMatches)
        {
            int failedAttempts = user.getFailedLoginCount() + 1;
            user.setFailedLoginCount(failedAttempts);

            if(failedAttempts >= MAX_FAILED_ATTEMPTS)
            {
                user.setLockedUntil(now.plusMinutes(LOCK_DURATION_MINUTES));
                userRepository.save(user);
                throw new InvalidCredentialsException("Your account has been locked due to multiple invalid login attempts!");
            }

            userRepository.save(user);

            throw new InvalidCredentialsException("Invalid email or password!");
        }

        user.setLockedUntil(null);
        user.setFailedLoginCount(0);

        userRepository.save(user);


        //normalizing the email before going to repo

        String normalizedEmail = NormalizationUtils.normalizeEmail(login.getEmail());

        //authenticating the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        normalizedEmail,
                        login.getPassword()
                )
        );

        //generating the jwt
        String token = jwtTokenProvider.generateToken(authentication);

        CustomeUserDetails userDetails = (CustomeUserDetails) authentication.getPrincipal();

        String roleStr = userDetails.getAuthorities()
                .stream()
                .findFirst()
                .map(a -> a.getAuthority())
                .orElse(null);

        return LoginResponseDto.builder()
                .accessToken(token)
                .tokenType("Bearer")
                .userRole(roleStr)
                .build();
    }
}
