package com.tss.security_demo.service.impl;

import com.tss.security_demo.entity.User;
import com.tss.security_demo.repository.UserRepository;
import com.tss.security_demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findByUsername(String username) {

        return userRepository.findByUsername(username);
    }
}
