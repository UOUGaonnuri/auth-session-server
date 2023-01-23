package com.gaounuri.authsessionserver.todo.controller;

import com.gaounuri.authsessionserver.constant.dto.BaseResponse;
import com.gaounuri.authsessionserver.todo.dto.TodoDTO;
import com.gaounuri.authsessionserver.todo.model.Todo;
import com.gaounuri.authsessionserver.todo.service.TodoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoController {

    private final TodoServiceImpl todoService;

    @GetMapping("/test")
    public ResponseEntity<BaseResponse<String>> test(){
        return ResponseEntity.ok().body(BaseResponse.success("Test"));
    }

    @GetMapping("/getTodos")
    public ResponseEntity<BaseResponse<List<Todo>>> getTodos(@RequestParam Long userId){
        List<Todo> result = todoService.getTodosByUserId(userId);
        return ResponseEntity.ok().body(BaseResponse.success(result));
    }

    @PostMapping("/createTodo")
    public ResponseEntity<BaseResponse<Long>> createTodo(@RequestBody TodoDTO.TodoContent request){
        Long result = todoService.createTodoContent(request);
        return ResponseEntity.ok().body(BaseResponse.success(result));
    }

    @PutMapping("/updateTodo")
    public ResponseEntity<BaseResponse<Long>> updateTodo(@RequestBody TodoDTO.UpdateTodo request){
        Long result = todoService.updateTodoContent(request);
        return ResponseEntity.ok().body(BaseResponse.success(result));
    }

    @DeleteMapping("/deleteTodo")
    public ResponseEntity<BaseResponse<Long>> deleteTodo(@RequestParam Long todoId){
        Long result = todoService.deleteTodoContent(todoId);
        return ResponseEntity.ok().body(BaseResponse.success(result));
    }
}
