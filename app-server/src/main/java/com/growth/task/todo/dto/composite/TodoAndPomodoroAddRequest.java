package com.growth.task.todo.dto.composite;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.growth.task.pomodoro.dto.request.PomodoroAddRequest;
import com.growth.task.todo.dto.request.TodoAddRequest;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TodoAndPomodoroAddRequest {
    @Valid
    private TodoAddRequest todoAddRequest;

    @Valid
    private PomodoroAddRequest pomodoroAddRequest;

    @JsonCreator
    public TodoAndPomodoroAddRequest(
            @JsonProperty("task_id") Long taskId,
            @JsonProperty("todo") String todo,
            @JsonProperty("perform_count") int performCount,
            @JsonProperty("plan_count") int planCount
    ) {
        this.todoAddRequest = new TodoAddRequest(taskId, todo);
        this.pomodoroAddRequest = new PomodoroAddRequest(performCount, planCount);
    }

    @Builder
    public TodoAndPomodoroAddRequest(TodoAddRequest todoAddRequest, PomodoroAddRequest pomodoroAddRequest) {
        this.todoAddRequest = todoAddRequest;
        this.pomodoroAddRequest = pomodoroAddRequest;
    }
}
