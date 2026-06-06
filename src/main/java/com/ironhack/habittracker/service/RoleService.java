package com.ironhack.habittracker.service;

import com.ironhack.habittracker.model.Role;

public interface RoleService {
    Role save(Role role);
    void addRoleToUser(String username, String roleName);
}