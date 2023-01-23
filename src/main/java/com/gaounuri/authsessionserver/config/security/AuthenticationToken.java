package com.gaounuri.authsessionserver.config.security;

import com.gaounuri.authsessionserver.user.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationToken {
    private String username;
    private Role role;
    private String token;
}
