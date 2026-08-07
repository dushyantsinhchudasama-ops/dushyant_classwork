package com.tss.spring_security_app.security;

import com.tss.spring_security_app.entity.Role;
import com.tss.spring_security_app.entity.User;
import com.tss.spring_security_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomeUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByUserName(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found with username: " + username));

        Role role = user.getRole();

        Set<GrantedAuthority> authorities = new HashSet<>();

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
        authorities.add(authority);

        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(),
                authorities);
    }
}
