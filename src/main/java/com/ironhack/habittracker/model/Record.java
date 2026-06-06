package com.ironhack.habittracker.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private Boolean isCompleted;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "habit_id")
    private Habit habit;

    public Record(LocalDate date, Boolean isCompleted, String notes, Habit habit) {
        this.date = date;
        this.isCompleted = isCompleted;
        this.notes = notes;
        this.habit = habit;
    }
}