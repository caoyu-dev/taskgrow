package com.growth.task.pomodoro.controller;

import com.growth.task.pomodoro.domain.Pomodoros;
import com.growth.task.pomodoro.dto.request.PomodoroUpdateRequest;
import com.growth.task.pomodoro.dto.response.PomodoroUpdateResponse;
import com.growth.task.pomodoro.service.PomodoroService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/pomodoros")
public class PomodoroUpdateController {

    private final PomodoroService pomodoroService;

    public PomodoroUpdateController(PomodoroService pomodoroService) {
        this.pomodoroService = pomodoroService;
    }

    @PatchMapping("/{todoId}")
    @ResponseStatus(OK)
    public PomodoroUpdateResponse update(
            @PathVariable("todoId") Long todoId,
            @RequestBody @Valid PomodoroUpdateRequest pomodoroUpdateRequest
    ) {
        Pomodoros pomodoros = pomodoroService.update(todoId, pomodoroUpdateRequest);
        return new PomodoroUpdateResponse(pomodoros);
    }
}
