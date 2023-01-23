package com.gaounuri.authsessionserver.todo.model;

import com.gaounuri.authsessionserver.constant.entity.BaseEntity;
import com.gaounuri.authsessionserver.todo.dto.TodoDTO;
import com.gaounuri.authsessionserver.todo.enums.Status;
import lombok.*;

import javax.persistence.*;

@Table(name = "todo")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Todo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long todoId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "todo_content")
    private String todoContent;

    @Column(name = "todo_status")
    @Enumerated(EnumType.STRING)
    private Status todoStatus;

    public static Todo createTodo(TodoDTO.TodoContent dto){
        return Todo.builder()
                .userId(dto.getUserId())
                .todoContent(dto.getContent())
                .todoStatus(Status.ASSIGNED)
                .build();
    }
}
