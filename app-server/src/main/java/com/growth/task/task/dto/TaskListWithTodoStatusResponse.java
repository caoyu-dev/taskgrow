package com.growth.task.task.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.growth.task.todo.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Task + Todos status DTO
 */
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
public class TaskListWithTodoStatusResponse {
    private Long taskId;
    private Long userId;
    private LocalDate taskDate;
    private Status todoStatus;

    public TaskListWithTodoStatusResponse(Long taskId, Long userId, LocalDate taskDate, Status todoStatus) {
        this.taskId = taskId;
        this.userId = userId;
        this.taskDate = taskDate;
        this.todoStatus = todoStatus;
    }
}
