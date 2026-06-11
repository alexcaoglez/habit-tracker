package com.ironhack.habittracker.service;

import com.ironhack.habittracker.model.Habit;
import com.ironhack.habittracker.model.Record;
import com.ironhack.habittracker.repository.HabitRepository;
import com.ironhack.habittracker.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecordService {
    private final RecordRepository recordRepository;
    private final HabitRepository habitRepository;

    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }

    public Optional<Record> getRecordById(Long id) {
        return recordRepository.findById(id);
    }

    public List<Record> getRecordsByHabitId(Long habitId) {
        return recordRepository.findByHabitId(habitId);
    }

    public List<Record> getRecordsByHabitAndDateRange(Long habitId, LocalDate startDate, LocalDate endDate) {
        return recordRepository.findByHabitIdAndDateBetween(habitId, startDate, endDate);
    }

    // Método para crear un record cuando ya tienes el habitId
    public Record saveRecord(Long habitId, Record record) {
        Habit habit = habitRepository.findById(habitId).orElseThrow(
                () -> new RuntimeException("Habit not found with id: " + habitId)
        );
        record.setHabit(habit);
        return recordRepository.save(record);
    }

    // Método sobrecargado para crear un record cuando el hábito ya está asignado
    public Record saveRecord(Record record) {
        return recordRepository.save(record);
    }

    public Record updateRecord(Long id, Record updatedRecord) {
        Record recordToUpdate = getRecordById(id).orElseThrow(
                () -> new RuntimeException("Record not found with id: " + id)
        );
        recordToUpdate.setIsCompleted(updatedRecord.getIsCompleted());
        recordToUpdate.setNotes(updatedRecord.getNotes());
        return recordRepository.save(recordToUpdate);
    }

    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }
}