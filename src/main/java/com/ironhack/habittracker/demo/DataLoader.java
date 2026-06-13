package com.ironhack.habittracker.demo;

import com.ironhack.habittracker.model.DailyHabit;
import com.ironhack.habittracker.model.Habit;
import com.ironhack.habittracker.model.Record;
import com.ironhack.habittracker.model.Role;
import com.ironhack.habittracker.model.User;
import com.ironhack.habittracker.model.WeeklyHabit;
import com.ironhack.habittracker.service.HabitService;
import com.ironhack.habittracker.service.RecordService;
import com.ironhack.habittracker.service.RoleService;
import com.ironhack.habittracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

// Carga datos de prueba cuando arranca la aplicación
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final UserService userService;
    private final RoleService roleService;
    private final HabitService habitService;
    private final RecordService recordService;

    @Override
    public void run(String... args) throws Exception {
        // Crear roles
        Role roleUser = roleService.save(new Role("ROLE_USER"));
        Role roleAdmin = roleService.save(new Role("ROLE_ADMIN"));

        // usuarios
        User alex = userService.saveUser(new User("Alejandro Cao", "alex.cao", "password123"));
        User maria = userService.saveUser(new User("María López", "maria.lopez", "maria2024"));
        User manuel = userService.saveUser(new User("Manuel García", "manuel.garcia", "manuel123"));
        User kike = userService.saveUser(new User("Enrique Rodríguez", "kike.rodriguez", "kike2024"));
        User salvatore = userService.saveUser(new User("Salvatore Bianchi", "salvatore.bianchi", "salva123"));
        User igor = userService.saveUser(new User("Igor Petrov", "igor.petrov", "igor2024"));
        User natalia = userService.saveUser(new User("Natalia Fernández", "natalia.fernandez", "natalia123"));

        // meterle roles
        roleService.addRoleToUser("alex.cao", "ROLE_USER");
        roleService.addRoleToUser("maria.lopez", "ROLE_ADMIN");
        roleService.addRoleToUser("manuel.garcia", "ROLE_USER");
        roleService.addRoleToUser("kike.rodriguez", "ROLE_USER");
        roleService.addRoleToUser("salvatore.bianchi", "ROLE_USER");
        roleService.addRoleToUser("igor.petrov", "ROLE_USER");
        roleService.addRoleToUser("natalia.fernandez", "ROLE_USER");

        // HÁBITOS DE ALEX
        Habit habit1 = new Habit(
                "Beber 2L de agua al día",
                "Mantenerse hidratado es fundamental para la salud",
                LocalDate.now().minusDays(30),
                alex
        );
        DailyHabit dailyHabit1 = new DailyHabit();
        dailyHabit1.setTitle(habit1.getTitle());
        dailyHabit1.setDescription(habit1.getDescription());
        dailyHabit1.setStartDate(habit1.getStartDate());
        dailyHabit1.setUser(alex);
        dailyHabit1.setCurrentStreak(15);
        habitService.saveHabit(dailyHabit1);

        Habit habit2 = new Habit(
                "Ir al gimnasio 3 veces por semana",
                "Lunes, miércoles y viernes - rutina de fuerza",
                LocalDate.now().minusDays(60),
                alex
        );
        WeeklyHabit weeklyHabit1 = new WeeklyHabit();
        weeklyHabit1.setTitle(habit2.getTitle());
        weeklyHabit1.setDescription(habit2.getDescription());
        weeklyHabit1.setStartDate(habit2.getStartDate());
        weeklyHabit1.setUser(alex);
        weeklyHabit1.setTargetDaysPerWeek(3);
        habitService.saveHabit(weeklyHabit1);

        Habit habit3 = new Habit(
                "Leer 30 minutos antes de dormir",
                "Libro actual: 'Clean Code' de Robert C. Martin",
                LocalDate.now().minusDays(45),
                alex
        );
        DailyHabit dailyHabit2 = new DailyHabit();
        dailyHabit2.setTitle(habit3.getTitle());
        dailyHabit2.setDescription(habit3.getDescription());
        dailyHabit2.setStartDate(habit3.getStartDate());
        dailyHabit2.setUser(alex);
        dailyHabit2.setCurrentStreak(22);
        habitService.saveHabit(dailyHabit2);

        // HÁBITOS DE MARÍA
        Habit habit4 = new Habit(
                "Meditar 10 minutos por la mañana",
                "Usando la app Headspace para guiarme",
                LocalDate.now().minusDays(20),
                maria
        );
        DailyHabit dailyHabit3 = new DailyHabit();
        dailyHabit3.setTitle(habit4.getTitle());
        dailyHabit3.setDescription(habit4.getDescription());
        dailyHabit3.setStartDate(habit4.getStartDate());
        dailyHabit3.setUser(maria);
        dailyHabit3.setCurrentStreak(18);
        habitService.saveHabit(dailyHabit3);

        Habit habit5 = new Habit(
                "Estudiar Java 1 hora al día",
                "Preparándome para el proyecto final de Ironhack",
                LocalDate.now().minusDays(15),
                maria
        );
        DailyHabit dailyHabit4 = new DailyHabit();
        dailyHabit4.setTitle(habit5.getTitle());
        dailyHabit4.setDescription(habit5.getDescription());
        dailyHabit4.setStartDate(habit5.getStartDate());
        dailyHabit4.setUser(maria);
        dailyHabit4.setCurrentStreak(12);
        habitService.saveHabit(dailyHabit4);

        // HÁBITOS DE MANUEL
        Habit habit6 = new Habit(
                "Correr 5km los martes y jueves",
                "Preparación para la carrera solidaria de diciembre",
                LocalDate.now().minusDays(40),
                manuel
        );
        WeeklyHabit weeklyHabit2 = new WeeklyHabit();
        weeklyHabit2.setTitle(habit6.getTitle());
        weeklyHabit2.setDescription(habit6.getDescription());
        weeklyHabit2.setStartDate(habit6.getStartDate());
        weeklyHabit2.setUser(manuel);
        weeklyHabit2.setTargetDaysPerWeek(2);
        habitService.saveHabit(weeklyHabit2);

        Habit habit7 = new Habit(
                "No mirar el móvil la primera hora del día",
                "Empezar la mañana con intención, no con notificaciones",
                LocalDate.now().minusDays(10),
                manuel
        );
        DailyHabit dailyHabit5 = new DailyHabit();
        dailyHabit5.setTitle(habit7.getTitle());
        dailyHabit5.setDescription(habit7.getDescription());
        dailyHabit5.setStartDate(habit7.getStartDate());
        dailyHabit5.setUser(manuel);
        dailyHabit5.setCurrentStreak(8);
        habitService.saveHabit(dailyHabit5);

        // HÁBITOS DE KIKE
        Habit habit8 = new Habit(
                "Practicar guitarra 20 minutos al día",
                "Aprendiendo 'Blackbird' de los Beatles",
                LocalDate.now().minusDays(25),
                kike
        );
        DailyHabit dailyHabit6 = new DailyHabit();
        dailyHabit6.setTitle(habit8.getTitle());
        dailyHabit6.setDescription(habit8.getDescription());
        dailyHabit6.setStartDate(habit8.getStartDate());
        dailyHabit6.setUser(kike);
        dailyHabit6.setCurrentStreak(14);
        habitService.saveHabit(dailyHabit6);

        Habit habit9 = new Habit(
                "Salir a caminar después de comer",
                "15 minutos de paseo para mejorar la digestión",
                LocalDate.now().minusDays(50),
                kike
        );
        DailyHabit dailyHabit7 = new DailyHabit();
        dailyHabit7.setTitle(habit9.getTitle());
        dailyHabit7.setDescription(habit9.getDescription());
        dailyHabit7.setStartDate(habit9.getStartDate());
        dailyHabit7.setUser(kike);
        dailyHabit7.setCurrentStreak(30);
        habitService.saveHabit(dailyHabit7);

        // HÁBITOS DE SALVATORE
        Habit habit10 = new Habit(
                "Escribir en el diario 10 minutos antes de dormir",
                "Reflexionar sobre el día y anotar 3 cosas buenas",
                LocalDate.now().minusDays(35),
                salvatore
        );
        DailyHabit dailyHabit8 = new DailyHabit();
        dailyHabit8.setTitle(habit10.getTitle());
        dailyHabit8.setDescription(habit10.getDescription());
        dailyHabit8.setStartDate(habit10.getStartDate());
        dailyHabit8.setUser(salvatore);
        dailyHabit8.setCurrentStreak(20);
        habitService.saveHabit(dailyHabit8);

        Habit habit11 = new Habit(
                "Hacer yoga los lunes y miércoles",
                "Clase online de 30 minutos con Yoga with Adriene",
                LocalDate.now().minusDays(55),
                salvatore
        );
        WeeklyHabit weeklyHabit3 = new WeeklyHabit();
        weeklyHabit3.setTitle(habit11.getTitle());
        weeklyHabit3.setDescription(habit11.getDescription());
        weeklyHabit3.setStartDate(habit11.getStartDate());
        weeklyHabit3.setUser(salvatore);
        weeklyHabit3.setTargetDaysPerWeek(2);
        habitService.saveHabit(weeklyHabit3);

        // HÁBITOS DE IGOR
        Habit habit12 = new Habit(
                "Estudiar inglés 30 minutos al día",
                "Usando Duolingo y viendo series en inglés sin subtítulos",
                LocalDate.now().minusDays(20),
                igor
        );
        DailyHabit dailyHabit9 = new DailyHabit();
        dailyHabit9.setTitle(habit12.getTitle());
        dailyHabit9.setDescription(habit12.getDescription());
        dailyHabit9.setStartDate(habit12.getStartDate());
        dailyHabit9.setUser(igor);
        dailyHabit9.setCurrentStreak(16);
        habitService.saveHabit(dailyHabit9);

        Habit habit13 = new Habit(
                "Programar un proyecto personal los fines de semana",
                "Construyendo un bot de Telegram con Python",
                LocalDate.now().minusDays(30),
                igor
        );
        WeeklyHabit weeklyHabit4 = new WeeklyHabit();
        weeklyHabit4.setTitle(habit13.getTitle());
        weeklyHabit4.setDescription(habit13.getDescription());
        weeklyHabit4.setStartDate(habit13.getStartDate());
        weeklyHabit4.setUser(igor);
        weeklyHabit4.setTargetDaysPerWeek(2);
        habitService.saveHabit(weeklyHabit4);

        //  HÁBITOS DE NATALIA
        Habit habit14 = new Habit(
                "Dormir 8 horas cada noche",
                "Acostarse antes de las 23:00 para descansar bien",
                LocalDate.now().minusDays(15),
                natalia
        );
        DailyHabit dailyHabit10 = new DailyHabit();
        dailyHabit10.setTitle(habit14.getTitle());
        dailyHabit10.setDescription(habit14.getDescription());
        dailyHabit10.setStartDate(habit14.getStartDate());
        dailyHabit10.setUser(natalia);
        dailyHabit10.setCurrentStreak(11);
        habitService.saveHabit(dailyHabit10);

        Habit habit15 = new Habit(
                "Cocinar en casa 4 veces por semana",
                "Evitar pedir delivery y comer más sano",
                LocalDate.now().minusDays(45),
                natalia
        );
        WeeklyHabit weeklyHabit5 = new WeeklyHabit();
        weeklyHabit5.setTitle(habit15.getTitle());
        weeklyHabit5.setDescription(habit15.getDescription());
        weeklyHabit5.setStartDate(habit15.getStartDate());
        weeklyHabit5.setUser(natalia);
        weeklyHabit5.setTargetDaysPerWeek(4);
        habitService.saveHabit(weeklyHabit5);

        // ==================== RECORDS DE EJEMPLO ====================
        Record record1 = new Record();
        record1.setDate(LocalDate.now().minusDays(1));
        record1.setIsCompleted(true);
        record1.setNotes("Hoy bebí toda el agua, me sentí con más energía");
        record1.setHabit(dailyHabit1);
        recordService.saveRecord(record1);

        Record record2 = new Record();
        record2.setDate(LocalDate.now());
        record2.setIsCompleted(true);
        record2.setNotes("Sesión de pecho y tríceps, muy bien");
        record2.setHabit(weeklyHabit1);
        recordService.saveRecord(record2);

        Record record3 = new Record();
        record3.setDate(LocalDate.now().minusDays(2));
        record3.setIsCompleted(false);
        record3.setNotes("No pude leer, estaba muy cansado del trabajo");
        record3.setHabit(dailyHabit2);
        recordService.saveRecord(record3);

        Record record4 = new Record();
        record4.setDate(LocalDate.now());
        record4.setIsCompleted(true);
        record4.setNotes("Meditación guiada de 10 minutos, me sentí muy relajada");
        record4.setHabit(dailyHabit3);
        recordService.saveRecord(record4);

        Record record5 = new Record();
        record5.setDate(LocalDate.now().minusDays(1));
        record5.setIsCompleted(true);
        record5.setNotes("Corrí 5.2km en 28 minutos, nuevo récord personal");
        record5.setHabit(weeklyHabit2);
        recordService.saveRecord(record5);

        Record record6 = new Record();
        record6.setDate(LocalDate.now());
        record6.setIsCompleted(true);
        record6.setNotes("Practiqué Blackbird, ya me sale casi entero");
        record6.setHabit(dailyHabit6);
        recordService.saveRecord(record6);

        System.out.println("Data loaded successfully!");
    }
}