package com.ironhack.habittracker.service.impl;

import com.ironhack.habittracker.model.Role;
import com.ironhack.habittracker.model.User;
import com.ironhack.habittracker.repository.RoleRepository;
import com.ironhack.habittracker.repository.UserRepository;
import com.ironhack.habittracker.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
        userRepository.save(user);
    }
}