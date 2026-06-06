package com.ironhack.habittracker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AIStatsService {
    private final ChatClient chatClient;

    public String getHabitInsights(String habitData) {
        return chatClient.prompt()
                .user("Analyze this habit tracking data and provide motivational insights and statistics: " + habitData)
                .call()
                .content();
    }

    public String getWeeklyReport(String weeklyData) {
        return chatClient.prompt()
                .user("Generate a weekly progress report based on this habit data: " + weeklyData)
                .call()
                .content();
    }
}