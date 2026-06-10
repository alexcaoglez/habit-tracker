package com.ironhack.habittracker.controller;

import com.ironhack.habittracker.model.User;
import com.ironhack.habittracker.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controlador para los usuarios
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // GET /api/users -> devuelve todos los usuarios
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    // POST /api/users -> crea un usuario nuevo
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody @Valid User user) {
        userService.saveUser(user);
    }
}