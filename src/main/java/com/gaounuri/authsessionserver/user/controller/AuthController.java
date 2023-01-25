package com.gaounuri.authsessionserver.user.controller;

import com.gaounuri.authsessionserver.constant.dto.BaseResponse;
import com.gaounuri.authsessionserver.user.dto.TestUserDTO;
import com.gaounuri.authsessionserver.user.service.TestUserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpHeaders.SET_COOKIE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/v1")
@Slf4j
public class AuthController {

    private final TestUserServiceImpl testUserService;
    @PostMapping("/register")
    public ResponseEntity<BaseResponse<Long>> register(@RequestBody TestUserDTO.UserRegisterForm registerForm){
        Long result = testUserService.register(registerForm);
        return ResponseEntity.ok().body(BaseResponse.success(result));
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<TestUserDTO.UserDetail>> login(@RequestBody TestUserDTO.UserLoginForm loginForm){
        TestUserDTO.UserDetail result = testUserService.login(loginForm);
        return ResponseEntity.ok().body(BaseResponse.success(result));
    }

    @PostMapping("/logout")
    public ResponseEntity<BaseResponse<Boolean>> logout(){
        ResponseCookie jsessionIDCookie = ResponseCookie.from("JSESSIONID", "delete")
                .path("/")
                .httpOnly(true)
                .maxAge(0)
                .build();
        ResponseCookie rememberMeCookie = ResponseCookie.from("remember-me", "delete")
                .path("/")
                .httpOnly(true)
                .maxAge(0)
                .build();

        return ResponseEntity.ok().header(SET_COOKIE, jsessionIDCookie.toString(), rememberMeCookie.toString())
                .body(BaseResponse.success(Boolean.TRUE));
    }

}
