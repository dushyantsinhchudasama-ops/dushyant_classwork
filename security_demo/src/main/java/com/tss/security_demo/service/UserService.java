package com.tss.security_demo.service;

import com.tss.security_demo.entity.User;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);
}
