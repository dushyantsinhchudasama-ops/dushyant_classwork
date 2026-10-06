package com.tss.security_demo.security;

import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

@Getter
@Builder
public class CustomeUserDetails implements UserDetails {

    private final UUID userId;
    private final String username;
    private final String password;

    private final Collection<? extends GrantedAuthority> authorities;

    private final Integer failedLoginCount;
    private final LocalDateTime lockedUntil;
    private final Boolean isActive;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonLocked() {
        return lockedUntil == null ||
                !lockedUntil.isAfter(LocalDateTime.now());
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}