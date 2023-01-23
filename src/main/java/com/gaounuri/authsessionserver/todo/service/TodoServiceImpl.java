package com.gaounuri.authsessionserver.todo.service;

import com.gaounuri.authsessionserver.constant.enums.ErrorCode;
import com.gaounuri.authsessionserver.constant.exception.CustomException;
import com.gaounuri.authsessionserver.todo.dto.TodoDTO;
import com.gaounuri.authsessionserver.todo.model.Todo;
import com.gaounuri.authsessionserver.todo.model.repository.TodoRepository;
import com.gaounuri.authsessionserver.todo.service.inter.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public List<Todo> getTodosByUserId(Long userId) {
        return todoRepository.findAllByUserId(userId);
    }

    @Override
    public Long createTodoContent(TodoDTO.TodoContent request) {
        Todo entity = Todo.createTodo(request);
        todoRepository.save(entity);
        return entity.getTodoId();
    }

    @Override
    public Long updateTodoContent(TodoDTO.UpdateTodo request) {
        Todo entity = todoRepository.findById(request.getTodoId())
                .orElseThrow(()-> new CustomException(ErrorCode.TODO_NOT_FOUND));
        entity.setTodoContent(request.getContent());
        todoRepository.save(entity);
        return entity.getTodoId();
    }

    @Override
    public Long deleteTodoContent(Long TodoId) {
        todoRepository.deleteById(TodoId);
        return TodoId;
    }
}
