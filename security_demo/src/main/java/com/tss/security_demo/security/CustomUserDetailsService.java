package com.tss.security_demo.security;

import com.tss.security_demo.entity.User;
import com.tss.security_demo.repository.UserRepository;
import com.tss.security_demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.tss.security_demo.util.NormalizationUtils.normalizeEmail;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String email = normalizeEmail(username);

        //here also add code for checking weather it is admin login or user login

        User user = userService.findByUsername(email)
                .orElseThrow(()-> new UsernameNotFoundException("Invalid email or password"));

        return buildUser(user);
    }

    private CustomeUserDetails buildUser(User user)
    {
        return CustomeUserDetails.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .password(user.getPasswordHash())
                .authorities(List.of(
                        new SimpleGrantedAuthority(
                                "ROLE_" + user.getRole().name()
                        )
                ))
                .failedLoginCount(user.getFailedLoginCount())
                .lockedUntil(user.getLockedUntil())
                .isActive(user.getIsActive())
                .build();

    }
}
