package com.ironhack.habittracker.service;

import com.ironhack.habittracker.model.User;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUser(String username);
    List<User> getUsers();
}