package com.ironhack.habittracker.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

// Servicio para hablar con la IA de OpenAI
// Usamos ChatClient.Builder igual que en el ejemplo de clase HelloAI
@Service
public class AIStatsService {
    private final ChatClient chatClient;

    // El constructor recibe el Builder y construye el ChatClient aquí
    public AIStatsService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    // Pide a la IA un análisis motivacional sobre los hábitos
    public String getHabitInsights(String habitData) {
        return chatClient.prompt()
                .user("Analyze this habit tracking data and provide motivational insights and statistics: " + habitData)
                .call()
                .content();
    }

    // Pide a la IA un reporte semanal con los hábitos
    public String getWeeklyReport(String weeklyData) {
        return chatClient.prompt()
                .user("Generate a weekly progress report based on this habit data: " + weeklyData)
                .call()
                .content();
    }
}