package com.ironhack.habittracker.controller;

import com.ironhack.habittracker.model.Record;
import com.ironhack.habittracker.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/records")
@RequiredArgsConstructor
public class RecordController {
    private final RecordService recordService;

    @GetMapping
    public List<Record> getAllRecords() {
        return recordService.getAllRecords();
    }

    @GetMapping("/{id}")
    public Optional<Record> getRecordById(@PathVariable Long id) {
        return recordService.getRecordById(id);
    }

    @GetMapping("/habit/{habitId}")
    public List<Record> getRecordsByHabit(@PathVariable Long habitId) {
        return recordService.getRecordsByHabitId(habitId);
    }

    @GetMapping("/habit/{habitId}/range")
    public List<Record> getRecordsByDateRange(
            @PathVariable Long habitId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return recordService.getRecordsByHabitAndDateRange(habitId, startDate, endDate);
    }

    @PostMapping("/habit/{habitId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Record saveRecord(@PathVariable Long habitId, @RequestBody Record record) {
        return recordService.saveRecord(habitId, record);
    }

    @PutMapping("/{id}")
    public Record updateRecord(@PathVariable Long id, @RequestBody Record record) {
        return recordService.updateRecord(id, record);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecord(@PathVariable Long id) {
        recordService.deleteRecord(id);
    }
}