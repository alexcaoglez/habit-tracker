package com.ironhack.habittracker.controller;

import com.ironhack.habittracker.model.Habit;
import com.ironhack.habittracker.service.HabitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controlador para los hábitos, aquí se definen las rutas de la API
@RestController
@RequestMapping("/api/habits")
@RequiredArgsConstructor
public class HabitController {
    private final HabitService habitService;

    // GET /api/habits -> devuelve todos los hábitos
    @GetMapping
    public List<Habit> getAllHabits() {
        return habitService.getAllHabits();
    }

    // GET /api/habits/{id} -> devuelve un hábito por su id
    @GetMapping("/{id}")
    public Habit getHabitById(@PathVariable Long id) {
        return habitService.getHabitById(id).orElseThrow(
                () -> new RuntimeException("Habit not found with id: " + id)
        );
    }

    // POST /api/habits -> crea un hábito nuevo, usa @Valid para validar los datos
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Habit saveHabit(@RequestBody @Valid Habit habit) {
        return habitService.saveHabit(habit);
    }

    // PUT /api/habits/{id} -> actualiza un hábito existente
    @PutMapping("/{id}")
    public Habit updateHabit(@PathVariable Long id, @RequestBody @Valid Habit habit) {
        return habitService.updateHabit(id, habit);
    }

    // DELETE /api/habits/{id} -> borra un hábito
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHabit(@PathVariable Long id) {
        habitService.deleteHabit(id);
    }
}