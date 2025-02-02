package com.growth.task.pomodoro.domain;

import com.growth.task.commons.domain.BaseTimeEntity;
import com.growth.task.todo.domain.Todos;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Entity
@DynamicUpdate
public class Pomodoros extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pomodoro_id")
    private long pomodoroId;

    @OneToOne
    @JoinColumn(name = "todo_id",
            referencedColumnName = "todo_id",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT)
    )
    private Todos todo;

    @Column(name = "perform_count", nullable = false)
    private int performCount;

    @Column(name = "plan_count", nullable = false)
    private int planCount;

    @Builder
    public Pomodoros(long pomodoroId, Todos todo, int performCount, int planCount) {
        this.pomodoroId = pomodoroId;
        this.todo = todo;
        this.performCount = performCount;
        this.planCount = planCount;
    }

    protected Pomodoros() {
    }

    public void updatePerformCount(int performCount) {
        this.performCount = performCount;
    }

    public void updatePlanCount(int planCount) {
        this.planCount = planCount;
    }
}
