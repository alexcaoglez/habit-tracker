package com.ironhack.habittracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class WeeklyHabit extends Habit {
    @Column(name = "target_days_per_week")
    private Integer targetDaysPerWeek;

    public WeeklyHabit(String title, String description, LocalDate startDate, User user, Integer targetDaysPerWeek) {
        super(title, description, startDate, user);
        this.targetDaysPerWeek = targetDaysPerWeek;
    }
}