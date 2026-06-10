package com.ironhack.habittracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Title cannot be empty")
    private String title;

    private String description;
    private LocalDate startDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Record> records = new ArrayList<>();

    public Habit(String title, String description, LocalDate startDate, User user) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.user = user;
    }
}