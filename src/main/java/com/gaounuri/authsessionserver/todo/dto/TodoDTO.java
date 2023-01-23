package com.gaounuri.authsessionserver.todo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

public class TodoDTO {

    @Data
    @Builder
    @RequiredArgsConstructor
    public static class TodoContent {
        private Long userId;
        private String content;
    }

    @Data
    @Builder
    @RequiredArgsConstructor
    public static class UpdateTodo {
        private Long todoId;
        private String content;
    }
}
