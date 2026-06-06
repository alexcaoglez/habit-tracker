package com.ironhack.habittracker.controller;

import com.ironhack.habittracker.model.Habit;
import com.ironhack.habittracker.service.HabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/habits")
@RequiredArgsConstructor
public class HabitController {
    private final HabitService habitService;

    @GetMapping
    public List<Habit> getAllHabits() {
        return habitService.getAllHabits();
    }

    @GetMapping("/{id}")
    public Optional<Habit> getHabitById(@PathVariable Long id) {
        return habitService.getHabitById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Habit> getHabitsByUser(@PathVariable Long userId) {
        return habitService.getHabitsByUserId(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Habit saveHabit(@RequestBody Habit habit) {
        return habitService.saveHabit(habit);
    }

    @PutMapping("/{id}")
    public Habit updateHabit(@PathVariable Long id, @RequestBody Habit habit) {
        return habitService.updateHabit(id, habit);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHabit(@PathVariable Long id) {
        habitService.deleteHabit(id);
    }
}