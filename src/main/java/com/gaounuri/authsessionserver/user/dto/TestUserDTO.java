package com.gaounuri.authsessionserver.user.dto;

import com.gaounuri.authsessionserver.user.enums.Role;
import lombok.*;

public class TestUserDTO {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserDetail {
        private Long userId;
        private String userName;
        private String userEmail;
        private Role role;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserLoginForm {
        private String userName;
        private String password;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserRegisterForm {
        private String userName;
        private String userEmail;
        private String password;
    }
}
