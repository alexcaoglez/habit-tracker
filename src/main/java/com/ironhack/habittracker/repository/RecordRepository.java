package com.ironhack.habittracker.repository;

import com.ironhack.habittracker.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findByHabitId(Long habitId);
    List<Record> findByHabitIdAndDateBetween(Long habitId, LocalDate startDate, LocalDate endDate);
}