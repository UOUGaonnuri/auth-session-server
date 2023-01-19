package com.gaounuri.authsessionserver.user.service.inter;

import com.gaounuri.authsessionserver.user.dto.TestUserDTO;

public interface TestUserService {
    Long addUser(TestUserDTO.UserDetail dto);
    TestUserDTO.UserDetail get(Long userID);
}
