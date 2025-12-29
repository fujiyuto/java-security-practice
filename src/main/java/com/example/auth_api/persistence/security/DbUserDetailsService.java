package com.example.auth_api.persistence.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.auth_api.app.domain.model.User;
import com.example.auth_api.app.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DbUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) {
        // ユーザデータ取得(Domain entity)
        User user = userRepository.findByUserName(userName);

        // Spring Securityでのユーザ情報
        return new CustomUserDetail(user.getEmail(), user.getPassword(), user.getRole());
    }
}
