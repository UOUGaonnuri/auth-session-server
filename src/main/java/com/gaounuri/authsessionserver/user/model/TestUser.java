package com.gaounuri.authsessionserver.user.model;

import com.gaounuri.authsessionserver.constant.entity.BaseEntity;
import com.gaounuri.authsessionserver.user.dto.TestUserDTO;
import com.gaounuri.authsessionserver.user.enums.Role;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "test_user")
@Data
@RequiredArgsConstructor
@Builder
public class TestUser extends BaseEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name="user_email", unique = true)
    private String userEmail;

    @Column(name ="password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", columnDefinition = "varchar(15) default 'ROLE_USER'")
    private Role role;

    public static TestUser createUser(TestUserDTO.UserRegisterForm registerForm, PasswordEncoder passwordEncoder){
        return TestUser.builder()
                .userName(registerForm.getUserName())
                .userEmail(registerForm.getUserEmail())
                .password(passwordEncoder.encode(registerForm.getPassword()))
                .build();
    }

}
