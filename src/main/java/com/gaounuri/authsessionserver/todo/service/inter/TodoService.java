package com.gaounuri.authsessionserver.todo.service.inter;

import com.gaounuri.authsessionserver.todo.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    List<TodoDTO.TodoDto> getTodosByUserId(Long userId);
    Long createTodoContent(TodoDTO.TodoContent request);
    Long changeTodoStatus(Long todoId);
    Long deleteTodoContent(Long todoId);
}
