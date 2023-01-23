package com.gaounuri.authsessionserver.user.model;

import com.gaounuri.authsessionserver.constant.entity.BaseEntity;
import com.gaounuri.authsessionserver.todo.model.Todo;
import com.gaounuri.authsessionserver.user.dto.TestUserDTO;
import com.gaounuri.authsessionserver.user.enums.Role;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "test_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Todo> todos = new ArrayList<>();

    public static TestUser createUser(TestUserDTO.UserRegisterForm registerForm, PasswordEncoder passwordEncoder){
        return TestUser.builder()
                .userName(registerForm.getUserName())
                .userEmail(registerForm.getUserEmail())
                .role(Role.USER)
                .password(passwordEncoder.encode(registerForm.getPassword()))
                .build();
    }

}
