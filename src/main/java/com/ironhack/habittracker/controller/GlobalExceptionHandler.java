package com.ironhack.habittracker.controller;

import com.ironhack.habittracker.dto.ErrorDto;
import com.ironhack.habittracker.exceptions.HabitTrackerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, List<String>> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    String field = error.getField();
                    String message = error.getDefaultMessage();
                    errors.computeIfAbsent(field, k -> new ArrayList<>())
                            .add(message);
                });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(HabitTrackerException.class)
    public ResponseEntity<ErrorDto> handleHabitTrackerException(HabitTrackerException ex) {
        return ResponseEntity.status(400).body(new ErrorDto(ex.getClass().getSimpleName(), ex.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return ResponseEntity.status(400).body(error);
    }
}