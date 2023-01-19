package com.gaounuri.authsessionserver.user.service;

import com.gaounuri.authsessionserver.constant.enums.ErrorCode;
import com.gaounuri.authsessionserver.constant.exception.CustomException;
import com.gaounuri.authsessionserver.user.model.TestUser;
import com.gaounuri.authsessionserver.user.model.repository.TestUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final TestUserRepository testUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TestUser user = testUserRepository.findByTestUserByUsername(username)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        return User.builder()
                .username(user.getUserName())
                .password(user.getPassword())
                .roles(user.getRole().toString())
                .build();
    }
}
