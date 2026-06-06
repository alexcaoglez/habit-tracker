package com.ironhack.habittracker.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "habit")
@Inheritance(strategy = InheritanceType.JOINED)
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate startDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Record> records = new ArrayList<>();

    public Habit(String title, String description, LocalDate startDate, User user) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.user = user;
    }
}