package com.ironhack.habittracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @NotEmpty(message = "Username cannot be empty")
    private String username;

    @NotEmpty(message = "Password cannot be empty")
    private String password;

    @ManyToMany(fetch = EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Habit> habits = new ArrayList<>();

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
}