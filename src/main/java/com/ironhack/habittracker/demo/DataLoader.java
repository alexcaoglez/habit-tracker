package com.ironhack.habittracker.demo;

import com.ironhack.habittracker.model.DailyHabit;
import com.ironhack.habittracker.model.Role;
import com.ironhack.habittracker.model.User;
import com.ironhack.habittracker.model.WeeklyHabit;
import com.ironhack.habittracker.repository.HabitRepository;
import com.ironhack.habittracker.repository.RecordRepository;
import com.ironhack.habittracker.service.RoleService;
import com.ironhack.habittracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final UserService userService;
    private final RoleService roleService;
    private final HabitRepository habitRepository;
    private final RecordRepository recordRepository;

    @Override
    public void run(String... args) throws Exception {
        roleService.save(new Role("ROLE_USER"));
        roleService.save(new Role("ROLE_ADMIN"));

        User user1 = userService.saveUser(new User("Alex Garcia", "alex", "1234"));
        User user2 = userService.saveUser(new User("Maria Lopez", "maria", "1234"));

        roleService.addRoleToUser("alex", "ROLE_USER");
        roleService.addRoleToUser("maria", "ROLE_ADMIN");

        DailyHabit dailyHabit1 = new DailyHabit("Drink water", "Drink 2L of water daily", LocalDate.now(), user1, 5);
        DailyHabit dailyHabit2 = new DailyHabit("Exercise", "30 min workout", LocalDate.now(), user1, 3);
        WeeklyHabit weeklyHabit1 = new WeeklyHabit("Read", "Read 3 hours per week", LocalDate.now(), user1, 3);

        habitRepository.save(dailyHabit1);
        habitRepository.save(dailyHabit2);
        habitRepository.save(weeklyHabit1);

        com.ironhack.habittracker.model.Record record1 = new com.ironhack.habittracker.model.Record(LocalDate.now(), true, "Completed morning session", dailyHabit1);
        com.ironhack.habittracker.model.Record record2 = new com.ironhack.habittracker.model.Record(LocalDate.now().minusDays(1), true, "Good progress", dailyHabit1);
        recordRepository.save(record1);
        recordRepository.save(record2);

        System.out.println("Data loaded successfully!");
    }
}