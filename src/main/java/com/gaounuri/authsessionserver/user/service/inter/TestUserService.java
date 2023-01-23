package com.gaounuri.authsessionserver.user.service.inter;

import com.gaounuri.authsessionserver.user.dto.TestUserDTO;


public interface TestUserService {
    Long register(TestUserDTO.UserRegisterForm dto);
    TestUserDTO.UserDetail login(TestUserDTO.UserLoginForm dto);
    TestUserDTO.UserDetail get(Long userID);


}
