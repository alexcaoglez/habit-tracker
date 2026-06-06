package com.ironhack.habittracker.controller;

import com.ironhack.habittracker.service.AIStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class AIStatsController {
    private final AIStatsService aiStatsService;

    @PostMapping("/insights")
    public String getInsights(@RequestBody String habitData) {
        return aiStatsService.getHabitInsights(habitData);
    }

    @PostMapping("/weekly-report")
    public String getWeeklyReport(@RequestBody String weeklyData) {
        return aiStatsService.getWeeklyReport(weeklyData);
    }
}