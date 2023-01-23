package com.gaounuri.authsessionserver.user.model.repository;

import com.gaounuri.authsessionserver.user.model.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestUserRepository extends JpaRepository<TestUser, Long> {
    Optional<TestUser> findTestUserByUserName(String userName);
    Boolean existsTestUserByUserNameOrUserEmail(String userName, String userEmail);
}
