package com.ironhack.habittracker.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;  // ← AÑADE ESTA LÍNEA

@Entity
@Data
@NoArgsConstructor
public class DailyHabit extends Habit {
    private Integer currentStreak;

    public DailyHabit(String title, String description, LocalDate startDate, User user, Integer currentStreak) {
        super(title, description, startDate, user);
        this.currentStreak = currentStreak;
    }
}
