package com.ironhack.habittracker.service;

import com.ironhack.habittracker.model.Habit;
import com.ironhack.habittracker.repository.HabitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HabitService {
    private final HabitRepository habitRepository;

    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }

    public Optional<Habit> getHabitById(Long id) {
        return habitRepository.findById(id);
    }

    public List<Habit> getHabitsByUserId(Long userId) {
        return habitRepository.findByUserId(userId);
    }

    public Habit saveHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    public Habit updateHabit(Long id, Habit updatedHabit) {
        Habit habitToUpdate = getHabitById(id).orElseThrow(
                () -> new RuntimeException("Habit not found with id: " + id)
        );
        habitToUpdate.setTitle(updatedHabit.getTitle());
        habitToUpdate.setDescription(updatedHabit.getDescription());
        return habitRepository.save(habitToUpdate);
    }

    public void deleteHabit(Long id) {
        habitRepository.deleteById(id);
    }
}