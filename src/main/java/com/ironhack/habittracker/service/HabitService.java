package com.ironhack.habittracker.service;

import com.ironhack.habittracker.model.Habit;
import com.ironhack.habittracker.repository.HabitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Servicio para gestionar hábitos, aquí va la lógica de negocio
@Service
@RequiredArgsConstructor
public class HabitService {
    private final HabitRepository habitRepository;

    // Devuelve todos los hábitos de la base de datos
    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }

    // Busca un hábito por su id
    public Optional<Habit> getHabitById(Long id) {
        return habitRepository.findById(id);
    }

    // Devuelve los hábitos de un usuario concreto
    public List<Habit> getHabitsByUserId(Long userId) {
        return habitRepository.findByUserId(userId);
    }

    // Guarda un hábito nuevo en la base de datos
    public Habit saveHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    // Actualiza un hábito existente, si no existe lanza excepción
    public Habit updateHabit(Long id, Habit updatedHabit) {
        Habit habitToUpdate = getHabitById(id).orElseThrow(
                () -> new RuntimeException("Habit not found with id: " + id)
        );
        habitToUpdate.setTitle(updatedHabit.getTitle());
        habitToUpdate.setDescription(updatedHabit.getDescription());
        return habitRepository.save(habitToUpdate);
    }

    // Borra un hábito por su id
    public void deleteHabit(Long id) {
        habitRepository.deleteById(id);
    }
}