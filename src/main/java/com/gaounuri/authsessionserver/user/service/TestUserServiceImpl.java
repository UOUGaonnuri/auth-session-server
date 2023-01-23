package com.gaounuri.authsessionserver.user.service;

import com.gaounuri.authsessionserver.constant.enums.ErrorCode;
import com.gaounuri.authsessionserver.constant.exception.CustomException;
import com.gaounuri.authsessionserver.user.dto.TestUserDTO;
import com.gaounuri.authsessionserver.user.model.TestUser;
import com.gaounuri.authsessionserver.user.model.repository.TestUserRepository;
import com.gaounuri.authsessionserver.user.service.inter.TestUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TestUserServiceImpl implements TestUserService {

    private final TestUserRepository testUserRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    @Override
    public Long register(TestUserDTO.UserRegisterForm dto) {
        if(testUserRepository.existsTestUserByUserNameOrUserEmail(dto.getUserName(), dto.getUserEmail())) {
            throw new CustomException(ErrorCode.USER_ALREADY_EXIST);
        }
        TestUser user = TestUser.createUser(dto, passwordEncoder);
        testUserRepository.save(user);
        return user.getUserId();
    }

    @Override
    public TestUserDTO.UserDetail login(TestUserDTO.UserLoginForm dto) {
        String username = dto.getUserName();
        String password = dto.getPassword();

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        TestUser user = testUserRepository.findTestUserByUserName(username)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        return TestUserDTO.UserDetail.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .userEmail(user.getUserName())
                .role(user.getRole())
                .build();
    }

    @Override
    public TestUserDTO.UserDetail get(Long userID) {
        return null;
    }
}
