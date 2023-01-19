package com.gaounuri.authsessionserver.user.model.repository;

import com.gaounuri.authsessionserver.user.model.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestUserRepository extends JpaRepository<TestUser, Long> {
    Optional<TestUser> findByTestUserByUsername(String username);
}
