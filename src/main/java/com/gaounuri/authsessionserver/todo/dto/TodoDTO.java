package com.gaounuri.authsessionserver.todo.dto;

import com.gaounuri.authsessionserver.todo.enums.Status;
import com.gaounuri.authsessionserver.todo.model.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class TodoDTO {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TodoDto {
        private Long todoId;
        private Long userId;
        private String content;
        private Status status;

        public static TodoDto entityToDTO(Todo entity){
            return TodoDto.builder()
                    .todoId(entity.getTodoId())
                    .userId(entity.getUserId())
                    .content(entity.getTodoContent())
                    .status(entity.getTodoStatus())
                    .build();
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TodoContent {
        private Long userId;
        private String content;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ChangeStatus {
        private Long todoId;
    }
}
