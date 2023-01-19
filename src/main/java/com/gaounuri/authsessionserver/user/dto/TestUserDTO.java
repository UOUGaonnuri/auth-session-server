package com.gaounuri.authsessionserver.user.dto;

import com.gaounuri.authsessionserver.user.enums.Role;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

public class TestUserDTO {
    @Data
    @Builder
    @RequiredArgsConstructor
    public static class UserDetail {
        private Long userId;
        private String userName;
        private String userEmail;
        private Role role;
    }

    @Data
    @Builder
    @RequiredArgsConstructor
    public static class UserRegisterForm {
        private String userName;
        private String userEmail;
        private String password;
    }
}
