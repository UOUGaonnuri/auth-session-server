package com.gaounuri.authsessionserver.todo.model.repository;

import com.gaounuri.authsessionserver.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByUserId(Long userId);
}
