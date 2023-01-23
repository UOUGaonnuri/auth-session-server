package com.gaounuri.authsessionserver.todo.service.inter;

import com.gaounuri.authsessionserver.todo.dto.TodoDTO;
import com.gaounuri.authsessionserver.todo.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getTodosByUserId(Long userId);
    Long createTodoContent(TodoDTO.TodoContent request);
    Long updateTodoContent(TodoDTO.UpdateTodo request);
    Long deleteTodoContent(Long TodoId);
}
